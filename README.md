# 🏗️ Projet de Gestion d'Entreprise de Construction

Ce projet est une application web modulaire destinée à gérer les différentes activités d'une entreprise de construction : utilisateurs, projets, tâches, ressources, finances, communication, pointage, formations, maintenance, incidents, et plus encore.

⚙️ Technologies utilisées

- **Backend** : Spring Boot (Java)
- **Frontend** : Angular
- **Base de données** : MySQL
- **Sécurité** : Keycloak (OIDC)
- **Architecture** : Microservices
- **Découverte de services** : Eureka
- **API Gateway** : Spring Cloud Gateway
- **Conteneurisation** : Docker & Docker Compose

🧱 Modules principaux

- **Gestion des utilisateurs** (authentification, rôles via Keycloak)
- **Gestion des projets** (planification, suivi, ressources associées)
- **Gestion des tâches** (assignation, progression, diagrammes)
- **Gestion des ressources matérielles** (stock, location, promotions)
- **Gestion financière** (budgets, dépenses, rapports)
- **Gestion de communication** (messagerie, notifications, blog)
- **Gestion du pointage** (arrivées, départs)
- **Recrutement** (candidats, entretiens, évaluation)
- **Formations et certifications**
- **Maintenance & historique**
- **Assurances & contrats**
- **Gestion des incidents**

🔐 Sécurité

L'application utilise **Keycloak** pour :
- Authentification centralisée
- Attribution de rôles (Admin, Utilisateur, Chef de projet, etc.)
- Contrôle d'accès par microservice et endpoint
- Token JWT pour sécuriser les communications


