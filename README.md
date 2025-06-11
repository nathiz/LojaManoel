# 📦 Projeto Empacotamento

API desenvolvida em Java com Spring Boot para simular o empacotamento de produtos em pedidos, utilizando caixas previamente cadastradas. A aplicação permite cadastrar pedidos e produtos, realizar o empacotamento de forma otimizada e visualizar os resultados.

---

## 🚀 Funcionalidades

- Cadastro de **pedidos** com múltiplos **produtos**
- Cadastro de **caixas**
- Endpoint para realizar o **empacotamento**
- Visualização do resultado com produtos alocados em caixas
- Interface Swagger para documentação e testes
- Console H2 para consulta de dados em memória

---

## 🛠️ Tecnologias e Ferramentas

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- H2 Database (memória)
- Lombok
- Swagger/OpenAPI
- Maven
- Docker (para versão com PostgreSQL)
- Postman (para testes)

---

## 📁 Estrutura do Projeto

```bash
src
├── main
│   ├── java/com/loja/empacotamento
│   │   ├── controller
│   │   ├── dto
│   │   ├── model
│   │   ├── repository
│   │   └── service
│   └── resources
│       ├── application.properties
│       └── data.sql
├── test
│   └── java/com/loja/empacotamento
│       └── controller
└── README.md
```

---

## 🧪 Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/empacotamento.git
cd empacotamento
```

### 2. Compilar e Rodar com Maven

```bash
mvn spring-boot:run
```

> A aplicação será iniciada em `http://localhost:8080`

---

## 🌐 Endpoints Disponíveis

Acesse a interface do Swagger para testar os endpoints:

📄 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Exemplos:
- `GET /pedidos`
- `POST /pedidos`
- `GET /produtos`
- `POST /produtos`
- `POST /empacotar`

---

## 🗃️ Banco de Dados H2

Acesse o console do H2 em:

🛠 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `S`

---

## 📦 Dados de Teste Padrão (`data.sql`)

O projeto vem com dados inseridos automaticamente para facilitar testes:

- Pedido: João com dois produtos
- Três caixas cadastradas
- Resultado de empacotamento simulado

---

## 🧪 Testes com Postman

Coleção pronta: `postman/empacotamento-collection.json`

Inclui:
- Cadastro de pedido
- Listagem de pedidos
- Empacotamento de pedido
- Listagem de resultados

---

## 🧯 Possíveis Erros e Soluções

| Erro | Causa | Solução |
|------|-------|---------|
| `Caused by: java.sql.SQLSyntaxErrorException` | Campos do `data.sql` não correspondem aos nomes nas entidades | Verifique nomes dos campos e ordem de inserção |
| `H2 console not available` | Spring não inicializou o console H2 | Confirme se `spring.h2.console.enabled=true` |
| `No converter found for return value` | Endpoint não está retornando o tipo correto | Ajustar o `@RestController` e tipos de retorno dos métodos |
| `Produto ou pedido não encontrado` | IDs informados não existem | Verifique se os dados foram populados corretamente |

---

## 🐳 Versão com Docker e PostgreSQL (Opcional)

Para rodar com banco persistente:

### 1. Subir o banco com Docker

```bash
docker-compose up -d
```

### 2. Alterar `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/empacotamento
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

---

## 🧠 Padrões e Boas Práticas Aplicadas

- **DTOs** para separação entre entidades e interface externa
- **Service layer** para lógica de negócio
- **Repository pattern** com Spring Data JPA
- **KISS, DRY e YAGNI** aplicados
- **Documentação Swagger**
- **Banco em memória para testes rápidos**

---