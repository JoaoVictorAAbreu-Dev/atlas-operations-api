# AtlasOps API

API backend para acompanhar operacao com eventos, saude operacional e historico para dashboards.

## Problema que resolve
- centraliza eventos operacionais
- acompanha saude do fluxo
- evidencia risco e criticidade
- cria base para auditoria e observabilidade de negocio

## Stack
- Java 21
- Spring Boot
- Spring Security com JWT
- Spring Data JPA
- PostgreSQL
- H2 para testes

## Funcionalidades
- login com usuario demo
- cadastro e consulta de eventos
- resumo da saude operacional
- seguranca com JWT

## Credenciais de demo
- email: `demo@atlasops.dev`
- senha: `atlas123`

## Variaveis de ambiente
- `DATABASE_URL`
- `DATABASE_USERNAME`
- `DATABASE_PASSWORD`
- `JWT_SECRET`
- `JWT_EXPIRATION_MINUTES`

## Execucao local
1. subir PostgreSQL com `docker compose up -d`
2. configurar as variaveis de ambiente
3. executar `mvn spring-boot:run`

## Testes
```bash
mvn test
```

## Estrutura principal
```text
src/main/java/com/jv/opsinsight
  auth/
  config/
  dashboard/
  exception/
  ops/
  security/
  user/
```

## Endpoints
- `GET /api/health`
- `POST /api/auth/login`
- `GET /api/events`
- `POST /api/events`
- `GET /api/dashboard`

## Observacoes de arquitetura
- controllers sem regra de negocio
- validacao com Bean Validation
- tratamento centralizado de erros
- usuarios demo persistidos em banco
- rotas protegidas por JWT

## Valor para LinkedIn
Projeto forte para mostrar backend com foco em operacao, rastreabilidade, autenticacao e consistencia de dados.
