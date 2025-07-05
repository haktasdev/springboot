# Java 17 içeren resmi image
FROM eclipse-temurin:17-jdk

# Uygulamanın çalışacağı dizin
WORKDIR /app

# Tüm proje dosyalarını container'a kopyala
COPY . .

# Maven wrapper ile derle
RUN ./mvnw clean package -DskipTests

# Portu aç
EXPOSE 8080

# Uygulamayı başlat
CMD ["java", "-jar", "target/*.jar"]
