# API de Protocolos PBX

API REST para gerenciar protocolos de atendimento gerados no FreePBX. Permite consultar e excluir registros de protocolos de chamadas telefônicas.

## O que o projeto faz

- Lista todos os protocolos de atendimento cadastrados
- Busca protocolo específico por ID
- Exclui protocolos do banco de dados
- Expõe documentação Swagger automática
- Valida dados e trata erros de forma padronizada

## Problemas que resolve

- Centraliza gestão de protocolos de atendimento
- Facilita integração com sistemas de CRM
- Permite auditoria de atendimentos
- Fornece histórico de ligações com dados do cliente
- Elimina necessidade de acesso direto ao banco

## Tecnologias

- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- MySQL 8
- Lombok
- Swagger/OpenAPI 3
- Maven 3.6+

## Estrutura da tabela

```sql
CREATE TABLE protocolo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    protocolo BIGINT,
    telefone VARCHAR(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cpf_cnpj VARCHAR(20),
    context VARCHAR(50) NOT NULL,
    data_geracao DATETIME NOT NULL,
    timestamp_unix BIGINT
);
```

### 5. Acesse a documentação

Swagger UI disponível em:
```
http://localhost:8080/swagger-ui.html
```

## Estrutura do projeto

```
src/
└── main/
    └── java/
        └── br/com/redelognet/
            ├── configurations/
            │   └── CorsConfig.java           # Configuração CORS
            ├── controllers/
            │   └── ProtocoloController.java  # Endpoints REST
            ├── entities/
            │   └── Protocolo.java            # Modelo JPA
            ├── exception/
            │   ├── ExceptionResponse.java    # Resposta de erro
            │   ├── ResourceNotFoundException.java
            │   └── handler/
            │       └── CustomEntityResponseHandler.java
            ├── repositories/
            │   └── ProtocoloRepository.java  # Interface JPA
            ├── services/
            │   └── ProtocoloService.java     # Lógica de negócio
            └── ProtocoloPbxApplication.java  # Classe principal
```

## Configurações importantes

### Porta da aplicação

Edite `src/main/resources/application.properties`:

```properties
server.port=8080
```

### CORS (Cross-Origin)

Por padrão, aceita requisições de `http://localhost:4200`.

Para alterar, edite `CorsConfig.java`:

```java
.allowedOrigins("http://seu-frontend.com")
```

### Logs SQL

Para habilitar logs de queries SQL, edite `application.properties`:

```properties
spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=DEBUG
```

## Tratamento de erros

A API retorna erros no formato padronizado:

```json
{
  "timestamp": "2024-11-06T10:30:00.000+00:00",
  "message": "Mensagem de erro",
  "details": "uri=/caminho/da/requisicao"
}
```

**Códigos HTTP:**
- `200 OK`: Sucesso
- `404 NOT FOUND`: Recurso não encontrado
- `500 INTERNAL SERVER ERROR`: Erro interno

## Campos do modelo Protocolo

| Campo | Tipo | Descrição | Obrigatório |
|-------|------|-----------|-------------|
| id | Integer | ID único (auto incremento) | Sim |
| protocolo | Long | Número do protocolo | Não |
| telefone | String(20) | Telefone do cliente | Sim |
| nome | String(100) | Nome do cliente | Sim |
| cpfCnpj | String(20) | CPF ou CNPJ | Não |
| context | String(50) | Contexto do Asterisk | Sim |
| dataGeracao | LocalDateTime | Data/hora de criação | Sim |
| timestamp | Long | Timestamp Unix | Não |

## Melhorias futuras

- Adicionar endpoint POST para criar protocolos
- Adicionar endpoint PUT para atualizar protocolos
- Implementar paginação na listagem
- Adicionar filtros de busca (por telefone, data, etc)
- Criar relatórios estatísticos
- Adicionar autenticação JWT
- Implementar cache com Redis
- Adicionar testes unitários e de integração
- Criar jobs para limpeza de protocolos antigos


## Notas importantes

- A API usa encoding UTF-8 para suportar caracteres especiais
- Hibernate está configurado para não alterar estrutura do banco (`ddl-auto=none`)
- Logs SQL estão desabilitados por padrão para melhor performance
- Swagger UI facilita testes e documentação da API
- Lombok reduz código boilerplate (getters, setters, construtores)
