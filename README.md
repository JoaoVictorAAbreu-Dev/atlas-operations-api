# AtlasOps API

API backend para resolver a dor de acompanhamento operacional com historico, dashboards e rastreio de evolucao.

## Proposta
- Visao consolidada de operacao
- Historico de eventos e status
- Base para indicadores e auditoria
- Foco em times que precisam enxergar fluxo e gargalos
- Registro de eventos operacionais
- Snapshot de saude operacional

## Estrutura
```text
src/main/java/com/jv/opsinsight
  config/
  dashboard/
  exception/
  ops/
```

## Endpoints
- `GET /api/health`
- `GET /api/events`
- `POST /api/events`
- `GET /api/dashboard`

## Regras
- eventos críticos reduzem a saude operacional
- eventos acionaveis indicam necessidade de resposta
- o dashboard resume volume, criticidade e score

## LinkedIn
Projeto para demonstrar observabilidade de negocio e pensamento de produto aplicado a backend.

