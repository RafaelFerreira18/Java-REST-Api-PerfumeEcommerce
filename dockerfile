# Use an official Maven image as the base image
FROM maven:3.8.5-openjdk-17-slim AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . . 

RUN apt-get install maven -y
RUN mvn clean install

# Etapa 2: Criar a imagem final
FROM openjdk:17-jdk-alpine

EXPOSE 8080

COPY --from=build target/perfume_ecommerce-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]