# Desafio Técnico - Evoluir
Estágio em Desenvolvimento Fullstack

## 📌 Descrição do Desafio

---
Este projeto foi desenvolvido como parte do processo seletivo para estágio em Desenvolvimento Fullstack na empresa **RPE - Retail Payment Ecossystem S/A**.  
O objetivo é construir uma aplicação completa, simulando parte do ecossistema de uma fintech, com funcionalidades para **gerenciar clientes, faturas e pagamentos**. O desafio abrange modelagem de banco de dados, criação de API REST e desenvolvimento de uma interface web funcional.
---

## 🔧 Tecnologias utilizadas

- **Back-End:** Java 21, Spring Boot, Spring Data
- **Front-End:** HTML, CSS e JavaScript com React.js
- **Banco de Dados:** PostgreSQL
- **Outras:** [Swagger, JUnit (pendente), Docker (pendente)]
---


## 1. 📦 Banco de Dados

**Entidades principais:**
- Cliente: `id, nome, cpf, data_nascimento, status_bloqueio, limite_credito`
- Fatura: `id, cliente_id, data_vencimento, data_pagamento, valor, status`

**Scripts:**
- [ ] População inicial com até 10 registros
- [ ] Consulta de clientes com +3 dias de atraso e bloqueados
- [ ] Atualização do limite de crédito para zero de clientes bloqueados

---

## 2. 🔙 Back-End

**Tecnologias:** Java 21 + Spring Boot + Spring Data  
**Endpoints:**
- Clientes:
  - [ ] `GET /clientes` – Listar todos
  - [ ] `POST /clientes` – Cadastrar cliente
  - [ ] `GET /clientes/{id}` – Buscar cliente por ID
  - [ ] `PUT /clientes/{id}` – Atualizar/bloquear cliente
  - [ ] `GET /clientes/bloqueados` – Listar bloqueados
- Faturas:
  - [ ] `GET /faturas/{id}` – Listar faturas de um cliente
  - [ ] `PUT /faturas/{id}/pagamento` – Registrar pagamento
  - [ ] `GET /faturas/atrasadas` – Listar faturas em atraso

**Regras de Negócio:**
- [ ] Pagamento muda status da fatura para "Paga"
- [ ] Após 3 dias de atraso, cliente é "Bloqueado"
- [ ] Clientes bloqueados têm limite de crédito zerado

---

## 3. 🎨 Front-End

**Tecnologias:** HTML, CSS, JavaScript (ou React.js)

**Telas obrigatórias:**
- [ ] Listagem de Clientes (nome, CPF, idade, status, limite)
- [ ] Botão para ver faturas do cliente
- [ ] Tela de Faturas com botão para registrar pagamento

---

## ✅ Status da Implementação

| Item                           | Status     |
|--------------------------------|------------|
| Banco de Dados                 | ✅ Concluído  |
| API (Back-End)                 | ✅ Concluído  |
| Interface Web (Front-End)      | ✅ Concluído  |
| Documentação da API (Swagger)  | ✅ Concluído  |
| Testes unitários (JUnit)       | ❌ Não implementado |
| Docker / Docker Compose        | ❌ Não implementado |

---

## 💡 Melhorias Futuras

- Implementar testes unitários com JUnit para validação das regras de negócio
- Adicionar suporte a Docker e docker-compose para facilitar a execução do projeto
- Aprimorar a interface com responsividade e melhor UX
- Criar logs e tratamento de erros para a API

---

## 🚀 Execução do Projeto

### 🔧 Pré-requisitos

- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Node.js 18+](https://nodejs.org/en)
- [PostgreSQL](https://www.postgresql.org/) ou outro banco relacional (já configurado)
- Git (opcional)

---

### 🗃️ 1. Banco de Dados

1. Crie um banco de dados com o nome desejado (ex: `fintech_db`)
2. Edite o arquivo `application.properties` no backend com suas configurações:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/fintech_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
3. Execute o script scripts_sql/script_fintech.sql para popular as tabelas com dados de exemplo.

### 🖥️ 2. Back-End (Java + Spring Boot)
No terminal:

cd backend
./mvnw spring-boot:run

Caso esteja usando um editor como IntelliJ, você pode rodar diretamente a classe DesafioFintechApplication.

- A aplicação backend ficará disponível por padrão em: http://localhost:8080

- A documentação da API (Swagger) estará em: http://localhost:8080/swagger-ui/index.html

### 🌐 3. Front-End (React + Vite)
No terminal:

cd frontend
npm install
npm run dev

- A interface web será aberta automaticamente em: http://localhost:5173

Certifique-se de que o backend está rodando para que os dados sejam carregados corretamente.

## 🙋‍♀️ Observações

Este projeto foi desenvolvido dentro de um prazo limitado, com foco em entregar as funcionalidades principais do desafio (banco de dados, API e interface).  
Como ainda não tive contato prático com **Docker** e **testes unitários**, então esses tópicos ficaram pendentes, mas estão entre os tópicos que pretendo estudar e aprimorar em projetos futuros.

