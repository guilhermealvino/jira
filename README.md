# Mini Jira API

Uma API RESTful para gerenciamento de atividades inspirada no Jira, desenvolvida com Spring Boot para aprendizado usando dois bancos de dados: MongoDB e PostgreSQL para mesma aplicação. Quer dizer, num certo momento posso salvar no MongoDb e em outro, no PostgreSql.

## 🚀 Tecnologias

- **Java 17**
- **Spring Boot 3.4.5**
  - Spring Web
  - Spring Data MongoDB
  - Spring Data JPA
- **Banco de Dados**
  - MongoDB
  - PostgreSQL
- **Maven** - Gerenciamento de dependências

## 📋 Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- MongoDB instalado e rodando (padrão: `localhost:27017`)
- PostgreSQL instalado e configurado (opcional, caso queira usar JPA)

## 🛠️ Configuração

1. Clone o repositório:
   ```bash
   git clone [URL_DO_REPOSITORIO]
   cd jira
   ```

2. Configure as credenciais do banco de dados no arquivo `src/main/resources/application.yml`

3. Instale as dependências:
   ```bash
   mvn clean install
   ```

## 🚀 Executando a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📚 Endpoints da API

### Atividades

- `GET /api/atividades` - Lista todas as atividades
- `GET /api/atividades/{id}` - Busca uma atividade por ID
- `POST /api/atividades` - Cria uma nova atividade
- `PUT /api/atividades/{id}` - Atualiza uma atividade existente
- `DELETE /api/atividades/{id}` - Remove uma atividade

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/com/jira/
│   │   ├── adapters/
│   │   │   ├── input/rest/      # Controladores REST
│   │   │   └── output/persistence/  # Repositórios e entidades
│   │   ├── core/                # Lógica de negócios
│   │   └── commons/             # Classes utilitárias e enums
│   └── resources/
│       └── application.yml      # Configurações da aplicação
└── test/                        # Testes
```


