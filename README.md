Digital Banking
Description
Digital Banking est une application web complète permettant la gestion de comptes bancaires.
Elle offre la gestion des clients, des comptes (courants et épargnes) et des opérations (débiter, créditer).
Le backend est développé avec Spring Boot et JPA/Hibernate pour la persistance des données,
et le frontend avec Angular pour une interface utilisateur moderne et interactive.

Le projet intègre également la sécurisation via Spring Security et JWT (JSON Web Token),
et la documentation API avec Swagger/OpenAPI.

Fonctionnalités principales
Gestion des clients : création, modification, suppression, recherche

Gestion des comptes bancaires : comptes courants et comptes épargnes

Enregistrement et gestion des opérations : débit et crédit

Authentification sécurisée via JWT

Documentation interactive des API avec Swagger

Dashboard avec statistiques et graphiques (via Chart.js côté frontend)

Technologies utilisées
Backend :

Java 17

Spring Boot 2.6.7

Spring Data JPA / Hibernate

MySQL

Spring Security & JWT

Swagger (springdoc-openapi)

Frontend :

Angular 15+

Bootstrap 5

Chart.js

Installation et lancement
Prérequis
Java JDK 17

Maven 3.x

Node.js & npm

MySQL installé et configuré

Backend
Configurer la base de données MySQL et créer une base vide (ex: digital_banking_db)

Modifier le fichier application.properties ou application.yml avec tes identifiants DB

Depuis le dossier backend, lancer la commande :

bash
Copier
Modifier
mvn clean spring-boot:run
Le backend sera accessible sur http://localhost:8085 (ou port configuré).

Frontend
Aller dans le dossier frontend

Installer les dépendances :

bash
Copier
Modifier
npm install
Lancer le serveur Angular :

bash
Copier
Modifier
ng serve
Le frontend sera accessible sur http://localhost:4200.

Documentation API
Une fois le backend lancé, accéder à la documentation Swagger via :

bash
Copier
Modifier
http://localhost:8085/swagger-ui/index.html
