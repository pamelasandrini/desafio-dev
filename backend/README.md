# Projeto
API faz o upload de um arquivo txt com os dados das movimentações finanaceira de várias lojas.

## Tecnologias do projeto
- Java 8
- Spring Boot
- Spring Data JPA
- REST
- SQL Server
- Docker
- Docker Compose
- Lombok
- Swagger
- Maven
- Spock

## Arquitetura do projeto
Este projeto utiliza as camadas do clean architecture.

## Comandos Úteis
```sh
# Execução de build maven
mvn clean install

# Executando testes unitário 
# relatório de cobertura de teste em: {path}/backend/target/site/jacoco/index.html
mvn clean test

# Executando a aplicação
mvn spring-boot:run
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

