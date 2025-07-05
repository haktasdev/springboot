package com.huseyin.controller;

import com.huseyin.model.Company;
import com.huseyin.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    // Tüm kurumları listele
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Yeni kurum ekle
    @PostMapping
    public ResponseEntity<?> createCompany(@RequestBody Company company) {
        try {
            Company saved = companyRepository.save(company);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Hata oluştu: " + e.getMessage());
        }
    }

    // ID ile kurum getir
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    // ID ile kurum güncelle
    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany) {
        return companyRepository.findById(id).map(company -> {
            company.setName(updatedCompany.getName());
            company.setAddress(updatedCompany.getAddress());
            company.setYearEstablished(updatedCompany.getYearEstablished());
            return companyRepository.save(company);
        }).orElse(null);
    }

    // ID ile kurum sil
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }
}
