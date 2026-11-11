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

RN-008 — Revogação de acesso empresarial durante sessão ativa:
Quando o vínculo de um usuário com determinada empresa for bloqueado ou desativado, o ERP deverá impedir novas operações protegidas nessa empresa a partir da efetivação da alteração, independentemente da existência de uma sessão autenticada. O bloqueio não deverá afetar automaticamente os vínculos do usuário com outras empresas.

RN-009 — Bloqueio global de usuário:
Quando a conta global de um usuário estiver bloqueada, o ERP deverá impedir suas operações autenticadas em todas as empresas, independentemente do estado de seus vínculos empresariais. O bloqueio global não deverá excluir nem alterar automaticamente esses vínculos.

RN-010 — Preservação dos vínculos na reativação global:
A reativação de uma conta global deverá preservar os estados existentes dos vínculos empresariais do usuário. O acesso a cada empresa continuará condicionado ao estado de seu respectivo vínculo e às permissões atribuídas.

RN-011 — Auditoria de alterações do estado global:
O ERP deverá registrar o histórico de todas as alterações do estado global de um usuário, contendo o estado anterior, o novo estado, o responsável pela alteração, a data e hora e a justificativa. Os registros históricos deverão ser preservados para fins de auditoria.

RN-012 — Atomicidade das alterações de estado auditadas:
Toda alteração de estado sujeita à auditoria deverá ser confirmada juntamente com seu respectivo registro histórico. Caso qualquer uma dessas operações falhe, nenhuma das alterações deverá ser efetivada.
