📌 Description du Projet
Ce projet est un microservice backend Spring Boot qui gère deux modules principaux : la gestion des assurances et la gestion des pointages. Il offre des fonctionnalités CRUD complètes pour les administrateurs et les ouvriers, avec des notifications par e-mail et WhatsApp pour les mises à jour importantes.

🛠 Installation et Exécution
Cloner le dépôt (branche Assurance-Pointage) :
git clone -b Assurance-Pointage https://github.com/houssemmoumni/BackConstruction.git

Importer le projet dans votre IDE (IntelliJ, Eclipse, etc.).

Configurer la base de données et le serveur SMTP dans application.properties.

Lancer l'application avec Maven :
mvn spring-boot:run

✨ Fonctionnalités
1) Gestion des Assurances
Pour l'administrateur :

Gestion des contrats et des assurances (CRUD).

Affectation d'une assurance à un contrat.

Liste/modification/suppression des maintenances.

Envoi automatique d'un e-mail lors de la mise à jour d'une maintenance.

Pour l'ouvrier :

Gestion des maintenances.

Affectation d'un contrat et d'un projet à une maintenance.

2) Gestion des Pointages
Pour l'administrateur :

Consultation des pointages par administrateur.

Pour l'ouvrier :

Ajout d'une maintenance.

Téléchargement d'un PDF récapitulatif du pointage.

Notification WhatsApp lors de l'ajout d'un pointage.

🔗 Documentation API
Les endpoints détaillés sont disponibles via Swagger UI après le démarrage de l'application :

Accédez à : http://localhost:8222/swagger-ui.html
