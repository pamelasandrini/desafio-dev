##Projeto Spring Boot com SQL Server
Converte um arquivo .txt em objeto e faz o upload no banco de dados 

## Comandos Úteis
```sh
# Execução de build maven
mvn clean install

# Executando testes unitário 
# relatório de teste {path}/backend/target/site/jacoco/index.html
mvn clean test

# Executando a aplicação
mvn spring:boot run
```

Para executar o projeto primeiro é necessário subir o banco de dados:
```sh
docker-compose up
```

## Links Uteis

### health check
http://localhost:8000/health

### documentação swagger
http://localhost:8000/swagger-ui.html

