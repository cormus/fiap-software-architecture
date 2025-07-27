# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven/Gradle para o container
#COPY . /app/
COPY target/architecture-0.0.1-SNAPSHOT.jar  app.jar

# Expor a porta em que o Spring Boot estará escutando
EXPOSE 8080

#RUN apt update

#RUN apt install -y maven

# Comando para executar a aplicação
#CMD ["mvn", "spring-boot:run"]
CMD ["java", "-jar", "app.jar"]

