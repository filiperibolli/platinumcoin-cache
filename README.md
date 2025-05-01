# PlatinumCoin Cache
**Microserviço de Pedidos com MySQL e Redis usando Clean Architecture**

---

## 📖 Visão Geral

O **PlatinumCoin Cache** é um microserviço desenvolvido para gerenciar pedidos de maneira eficiente, combinando:

- Um modelo de **Clean Architecture** que separa claramente Domínio, Casos de Uso, Gateway, Infraestrutura e Interface.
- **MySQL** como banco de dados relacional, para persistência confiável.
- **Redis** para cache de leituras frequentes e controle de **idempotência** via cabeçalho `X-Idempotency-Key`, evitando duplicidade de processamento.
- **Bean Validation** no Domínio, com exceções estruturadas (`DomainException` e `ErrorDetail`) para relatórios de erros detalhados.
- **Docker Compose** disponível para subida da infra
- **Collection** disponível para testes locais
---

## 🚀 Tecnologias Principais

- **Java 21**
- **Spring Boot 3.4.5**
- **Spring Data JPA**
- **Spring Data Redis (Lettuce)**
- **MySQL 8.0**
- **Redis 7.0**
- **Lombok**
- **Maven**

---