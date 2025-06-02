# Application de Banque Digitale  
*Rapport Technique*

## Table des matières
- [Introduction](#introduction)  
- [Architecture du Projet](#architecture-du-projet)  
- [Technologies Utilisées](#technologies-utilisées)  
- [Implémentation](#implémentation)  
  - [Backend (Spring Boot)](#backend-spring-boot)  
  - [Frontend (Angular)](#frontend-angular)  
- [Fonctionnalités](#fonctionnalités)  
- [Captures d'écran](#captures-décran)  
- [Conclusion](#conclusion)

## Introduction  
Dans un contexte où la digitalisation des services financiers devient un enjeu majeur, ce projet vise à développer une application de banque digitale performante et sécurisée. L’objectif principal est de proposer une solution complète pour la gestion des clients, comptes et transactions, tout en garantissant une expérience utilisateur fluide et intuitive.  

Cette application combine la robustesse du framework Spring Boot pour le backend avec la richesse d’Angular pour le frontend, offrant ainsi une solution moderne, évolutive et adaptée aux besoins actuels du secteur bancaire.

## Architecture du Projet  
Le projet suit une architecture modulaire, favorisant une séparation claire entre la logique métier (backend) et l’interface utilisateur (frontend). Cette organisation facilite la maintenance, la montée en charge et l’évolution fonctionnelle.

### Structure Backend  
```plaintext
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
└── pom.xml



Structure Frontend
plaintext
Copier
Modifier
frontend/
├── src/
│   ├── app/
│   ├── assets/
│   └── environments/
└── package.json
Technologies Utilisées
Backend
Java 17

Spring Boot 3.4.5

Spring Data JPA

MySQL

Lombok

Swagger/OpenAPI

Frontend
Angular

PrimeNG

TypeScript

HTML/CSS

Implémentation
Backend (Spring Boot) Modèle de données
Le backend gère les données bancaires à travers plusieurs entités essentielles qui structurent les clients, les comptes et les opérations.

DTO pour les opérations de crédit :
java
Copier
Modifier
@Data
public class CreditDTO {
    private String accountId;
    private double amount;
    private String description;
}
Cette classe est utilisée pour transférer les informations lors d’une opération de crédit sur un compte, comprenant l’identifiant du compte, le montant à créditer et une description de l’opération.

Interface Account :
typescript
Copier
Modifier
export interface Account {
  id: string;
  balance: number;
  createdAt: Date;
  status: AccountStatus;
  type: string;
  customer: Customer;
}
Cette interface TypeScript définit la structure d’un compte bancaire côté frontend, en incluant les informations clés telles que le solde, le statut et le client associé.

Frontend (Angular)
Le frontend repose sur Angular, qui offre une interface utilisateur dynamique et réactive, avec PrimeNG pour des composants graphiques modernes.

Composant de Login
html
Copier
Modifier
<div class="surface-card p-4 shadow-2 border-round mt-[10%] w-[50%] m-auto">
  <div class="text-center mb-5">
    <div class="text-900 text-3xl font-medium mb-3">Welcome Back</div>
    <!-- ... autres éléments ... -->
  </div>
  <form [formGroup]="formLogin" (ngSubmit)="onSubmit()">
    <!-- ... formulaire de connexion ... -->
  </form>
</div>
Ce composant présente un formulaire de connexion simple et efficace, permettant aux utilisateurs de s’authentifier.

Composant des Comptes
html
Copier
Modifier
<p-card header="Liste Des Comptes" [style]="{'width': '100%'}">
  <p-table #dt [value]="accounts" [paginator]="true" [rows]="10">
    <!-- ... configuration du tableau ... -->
  </p-table>
</p-card>
Ce composant affiche la liste paginée des comptes, avec des fonctionnalités de tri et de navigation intégrées.

Fonctionnalités
API REST
L’application expose plusieurs endpoints REST facilitant la gestion complète des entités principales.

Gestion des Clients
GET /customers : Récupère la liste des clients.

POST /customers : Crée un nouveau client.

PUT /customers/{customerId} : Met à jour un client existant.

DELETE /customers/{id} : Supprime un client.

Gestion des Comptes
GET /accounts : Liste tous les comptes.

GET /accounts/{accountId} : Détaille un compte spécifique.

Gestion des Transactions
GET /accounts/{accountId}/operations : Historique complet des opérations d’un compte.

GET /accounts/{accountId}/pageOperations : Opérations paginées pour une meilleure gestion.

Captures d'écran
Page de Connexion
Interface simple permettant aux utilisateurs de se connecter.


Gestion des Clients
Liste des Clients (Vue Administrateur)
Affichage des clients avec options d’ajout, modification et suppression.


Liste des Clients (Vue Utilisateur)
Vue limitée aux fonctionnalités de consultation pour les utilisateurs standards.


Dialogue d'Ajout de Client
Formulaire pour saisir les informations d’un nouveau client.


Dialogue de Modification de Client
Interface pour modifier les données d’un client existant.


Dialogue de Suppression de Client
Fenêtre de confirmation avant suppression d’un client.


Gestion des Comptes
Liste des Comptes (Vue Administrateur)
Accès complet aux comptes et à leurs opérations.


Liste des Comptes (Vue Utilisateur)
Vue restreinte pour les utilisateurs sans droits d’édition.


Opérations
Liste des Opérations
Historique détaillé des transactions effectuées sur un compte.


Dialogue d'Opération
Interface de création d’une opération bancaire (débit, crédit, virement).


Conclusion
Ce projet illustre une application bancaire digitale complète, répondant aux besoins actuels en termes de gestion et de sécurité.

Points Forts
Architecture claire et évolutive facilitant la maintenance et les évolutions futures.

Interface utilisateur intuitive, responsive et accessible grâce à Angular et PrimeNG.

API REST robuste pour gérer efficacement clients, comptes et transactions.

Système d’authentification et de gestion des rôles garantissant la sécurité des données.

Perspectives d’évolution
Ajout de fonctionnalités avancées telles que le reporting analytique et la gestion multi-devises.

Intégration de services innovants, notamment des paiements mobiles et solutions blockchain.

Développement d’applications mobiles natives pour un accès facilité.

Cette application constitue une base solide pour accompagner la transformation digitale des institutions financières, offrant un équilibre entre performance, sécurité et expérience utilisateur.
