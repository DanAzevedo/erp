BR-001 — Initial company administrator: 
When a company is registered, the ERP must automatically assign the user who created it as its first administrator.

BR-002 — Mandatory administration: 
An active company must have at least one administrator with an active company membership.

BR-003 — Last administrator protection: 
The ERP must prevent operations that would leave an active company without any active administrators.

BR-004 — Custom role isolation: 
A custom role must belong exclusively to the company that created it. The ERP must prevent users from other companies from viewing, modifying, or assigning that role, including through direct API access.

BR-005 — Approval of newly inherited permissions: 
When new permissions are added to a global role, custom roles linked to it must retain their previous effective permissions until the new permissions are approved by an authorized user of the respective company.

BR-006 — Authorization to manage roles and permissions: 
The ERP must allow only users with specific authorization to manage roles and permissions, within the context of the company in which the action is performed.

BR-007 — Active company selection and context: 
The ERP must allow an authenticated user to select a company in which they have an active membership, establishing it as the operating context. All operations must respect the data and permissions associated with the selected company. Switching companies must require revalidation of the membership.

BR-008 — Revocation of company access during an active session: 
When a user's membership in a company is blocked or deactivated, the ERP must prevent further protected operations in that company as soon as the change takes effect, regardless of any existing authenticated session. The block must not automatically affect the user's memberships in other companies.

BR-009 — Global user blocking: 
When a user's global account is blocked, the ERP must prevent authenticated operations across all companies, regardless of the status of their company memberships. A global block must not automatically delete or modify those memberships.

BR-010 — Preservation of memberships upon global account reactivation: 
Reactivating a global account must preserve the existing statuses of the user's company memberships. Access to each company must remain subject to the status of the respective membership and the assigned permissions.

BR-011 — Audit Trail for Global User Status Changes:
The ERP shall maintain an audit trail of all changes to a user's global status, including the previous status, the new status, the person responsible for the change, the date and time of the change, and the justification. Historical records shall be retained for auditing purposes.

BR-012 — Atomicity of Audited Status Changes:
Every status change subject to auditing shall be committed atomically with its corresponding audit record. If either operation fails, the entire transaction shall be rolled back, ensuring that no changes are persisted.

BR-013 — Business Relationship Audit Log:
The ERP must record the history of all status changes of a business relationship, containing the affected relationship, the previous status, the new status, the user responsible for the change, the date and time, and the justification. Historical records must be preserved for audit purposes.
