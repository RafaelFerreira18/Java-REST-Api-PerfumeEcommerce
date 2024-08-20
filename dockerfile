# Etapa 1: Construir o JAR
FROM maven:3.8.5-openjdk-17 AS build

# Definir diretório de trabalho
WORKDIR /app

# Copiar arquivos de configuração do Maven e pom.xml
COPY pom.xml .

# Baixar as dependências do Maven (usar cache)
RUN mvn dependency:go-offline -B

# Copiar o código-fonte do projeto
COPY src ./src

# Compilar e empacotar a aplicação
RUN mvn clean package -DskipTests

# Etapa 2: Criar a imagem final
FROM openjdk:17-jdk-alpine

# Definir diretório de trabalho
WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]