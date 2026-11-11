RN-001 — Administrador inicial da empresa:
Ao cadastrar uma empresa, o ERP deverá associar automaticamente o usuário criador como seu primeiro administrador.

RN-002 — Administração obrigatória:
Uma empresa ativa deverá possuir pelo menos um administrador com vínculo ativo.

RN-003 — Proteção do último administrador:
O ERP deverá impedir operações que deixem uma empresa ativa sem administradores ativos.

RN-004 — Isolamento de papéis personalizados:
Um papel personalizado deverá pertencer exclusivamente à empresa que o criou. O ERP deverá impedir sua visualização, alteração ou atribuição por usuários de outras empresas, independentemente do acesso direto à API.

RN-005 — Aprovação de novas permissões herdadas:
Quando um papel global receber novas permissões, os papéis personalizados vinculados a ele deverão manter suas permissões efetivas anteriores até que as novas permissões sejam aprovadas por um usuário autorizado da respectiva empresa.

RN-006 — Autorização para gerenciamento de permissões:
O ERP deverá permitir o gerenciamento de papéis e permissões exclusivamente por usuários que possuam autorização específica para essa operação, respeitando o contexto da empresa em que a ação será executada.

RN-007 — Seleção e contexto da empresa ativa:
O ERP deverá permitir que um usuário autenticado selecione uma empresa à qual possua vínculo ativo, estabelecendo-a como contexto de operação. Todas as operações deverão respeitar os dados e as permissões correspondentes à empresa selecionada. A alternância entre empresas deverá exigir nova validação do vínculo.
