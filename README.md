# 🧠 Projeto Técnico: Empacotamento de Pedidos - Loja do Seu Manoel

Este projeto foi desenvolvido como parte de uma **avaliação técnica** para a empresa **L2**. Ele representa um **microserviço completo em Java com Spring Boot**, contendo todos os elementos esperados de uma aplicação moderna: API REST, testes, documentação, banco de dados, containerização e lógica de negócio real aplicada.

---

## 🚀 Visão Geral

- ✅ Microserviço Java com Spring Boot 3.5
- ✅ API RESTful com documentação Swagger
- ✅ Banco de dados em memória com H2
- ✅ Lógica de empacotamento de pedidos em caixas otimizadas
- ✅ Testes automatizados (unitários e de integração)
- ✅ Projeto containerizado com Docker
- ✅ Pipeline CI com GitHub Actions
- ✅ Preparado para produção com estrutura escalável

---

## 🔧 Tecnologias e Ferramentas

| Ferramenta/Tecnologia | Uso |
|------------------------|-----|
| **Java 17**            | Linguagem principal |
| **Spring Boot**        | Framework principal para API REST |
| **Spring Data JPA**    | Persistência de dados com ORM |
| **H2 Database**        | Banco de dados em memória para testes |
| **Swagger/OpenAPI**    | Documentação automática dos endpoints |
| **JUnit 5**            | Testes unitários e de integração |
| **MockMvc**            | Testes de endpoints REST |
| **Lombok**             | Redução de boilerplate em Java |
| **Docker**             | Containerização do microserviço |
| **Maven**              | Gerenciador de dependências |
| **GitHub Actions**     | Integração contínua (CI) automatizada |

---

## 📦 Funcionalidade Principal: Empacotamento

Este microserviço simula o sistema de empacotamento da **Loja do Seu Manoel**.

### 🧾 Entrada:
Um JSON com pedidos, onde cada pedido possui uma lista de produtos com dimensões.

### 🧠 Processamento:
Cada produto é analisado e alocado em uma das **caixas disponíveis** (30x40x80, 80x50x40, 50x80x60). A lógica tenta usar o **mínimo de caixas possível**.

### 📤 Saída:
Um JSON informando:
- Cliente
- Quais caixas foram usadas
- Quais produtos foram colocados em cada caixa

---

## 🧪 Testes

- ✅ **Testes unitários** com JUnit
- ✅ **Testes de integração** com `MockMvc`
- ✅ Testa requisições reais para o endpoint `/api/empacotar`

Rodar testes:

```bash
mvn test
```

---

## 🐳 Docker

### Build da imagem:

```bash
mvn clean package
docker build -t empacotamento-app .
```

### Rodar o container:

```bash
docker run -p 8080:8080 empacotamento-app
```

---

## 🔍 Swagger e Banco

- Swagger: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console  
  - JDBC: `jdbc:h2:mem:loja`
  - Usuário: `sa`

---

## ✅ Habilidades Comprovadas neste Projeto

- [x] Criação de API RESTful com Spring Boot
- [x] Modelagem de dados com JPA e H2
- [x] Criação de DTOs e lógica de mapeamento
- [x] Lógica de negócio com análise de espaço e otimização
- [x] Organização limpa por camadas (Controller, Service, DTO, Model)
- [x] Testes automatizados com cobertura real de lógica
- [x] Dockerização da aplicação
- [x] CI automatizado com GitHub Actions
- [x] Uso avançado de Swagger/OpenAPI
- [x] Manipulação de listas, estruturas de dados e mapeamento
- [x] Criação e execução de scripts SQL (data.sql)

---

Desenvolvido com dedicação e foco em qualidade técnica. 💻🚀
