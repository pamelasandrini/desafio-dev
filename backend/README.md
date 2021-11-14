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

### APIs


**Upload do arquivo**

POST
```json
http://localhost:8000/v1/transacoes/upload
```
file: CNAB.txt

Response: Status 201 - Created

**Busca todas as lojas**

GET
```json
http://localhost:8000/v1/lojas
```
Response:
```json
[
  {
    "dono": "string",
    "id": 0,
    "nome": "string"
  }
] 
```

**Busca todas as operações de uma loja**

GET
```json
http://localhost:8000/v1/lojas/{id}/saldo
```
Response:
```json
{
  "saldoEmConta": 0,
  "transacaoList": [
    {
      "cartao": "string",
      "cpf": "string",
      "data": "string",
      "hora": "string",
      "tipoTransacao": "DEBITO",
      "valor": 0
    }
  ]
}
```
