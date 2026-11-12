ADR-001 — Adoção de monólito modular
Status: Aceita
Contexto
O ERP está em sua fase inicial de desenvolvimento, com foco na gestão de usuários, empresas, vínculos e controle de acesso. Neste momento, precisamos estabelecer a modelagem do domínio, implementar o controle de acesso baseado em papéis (RBAC) e definir os mecanismos de auditoria.

O projeto também tem como objetivo desenvolver conhecimentos práticos de arquitetura de software e, futuramente, evoluir para um produto SaaS.

Começar com microsserviços acrescentaria desafios de comunicação entre serviços, implantação, tratamento de falhas e consistência de dados distribuídos. Esse esforço aumentaria a complexidade inicial e poderia reduzir a atenção dedicada às regras de negócio e à organização do sistema.
Decisão
O ERP será desenvolvido como um monolito modular em Java com Spring Boot, organizado em módulos com responsabilidades e limites definidos.

A aplicação será implantada como uma única unidade. A comunicação entre os módulos deverá respeitar suas interfaces e evitar o acesso direto aos detalhes internos de outros módulos.

Essa estrutura permitirá começar com uma operação mais simples e preservar a possibilidade de extrair módulos para serviços independentes, caso surjam necessidades que justifiquem essa mudança.
Consequências positivas
- Menor complexidade inicial de desenvolvimento, implantação e operação.
- Mais atenção à modelagem do domínio, às regras de negócio, ao RBAC e à auditoria.
- Maior facilidade para executar e depurar a aplicação localmente.
- Possibilidade de amadurecer os limites dos módulos antes de considerar sua distribuição em serviços.
Consequências negativas
- A implantação e o escalonamento ocorrerão inicialmente para a aplicação inteira.
- Falhas em um módulo poderão afetar outros módulos da aplicação.
- A manutenção dos limites entre módulos exigirá disciplina para evitar acoplamento excessivo.
- Uma futura extração para microsserviços exigirá adaptações; a modularização, por si só, não elimina esse trabalho.
Evolução futura
Aprendizado: Haverá pelo menos um exercício prático envolvendo microsserviços e comunicação distribuída.
Produto: A adoção de microsserviços em produção dependerá de justificativa técnica, não apenas do objetivo educacional.
O interesse em aprender sobre sistemas distribuídos também poderá motivar experimentos. Entretanto, a introdução de microsserviços no produto deverá considerar se os benefícios compensam os custos de comunicação, consistência distribuída, observabilidade e operação.
