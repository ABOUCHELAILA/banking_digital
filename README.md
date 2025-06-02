# Application de Banque Digitale  
*Rapport Technique Détaillé*

## Table des matières
- [Introduction](#introduction)  
- [Architecture du Projet](#architecture-du-projet)  
- [Technologies Utilisées](#technologies-utilisées)  
- [Implémentation](#implémentation)  
  - [Backend (Spring Boot)](#backend-spring-boot)  
  - [Frontend (Angular)](#frontend-angular)  
- [Fonctionnalités](#fonctionnalités)  
- [Exemples de Code](#exemples-de-code)  
- [Captures d'écran](#captures-décran)  
- [Conclusion et Perspectives](#conclusion-et-perspectives)

---

## Introduction

Ce projet consiste en une application de banque digitale visant à fournir une plateforme complète pour la gestion des clients, comptes bancaires et opérations financières.  

L’objectif est d’offrir une interface sécurisée et performante, combinant un backend solide construit avec Spring Boot et un frontend moderne réalisé avec Angular.

---

## Architecture du Projet

L’architecture se compose de deux modules principaux interconnectés :

### Backend  
- Expose une API REST pour gérer les entités métier (clients, comptes, opérations).  
- Communique avec une base de données MySQL via Spring Data JPA.  
- Gère la logique métier, la sécurité et les validations.  

### Frontend  
- Application web développée avec Angular, offrant une interface utilisateur dynamique et intuitive.  
- Communique avec le backend via HTTP/REST.  
- Utilise PrimeNG pour des composants UI avancés (tables, dialogues, formulaires).

---

## Technologies Utilisées

### Backend  
- **Java 17**  
- **Spring Boot 3.4.5**  
- **Spring Data JPA** (pour l’accès à la base de données)  
- **MySQL** (base de données relationnelle)  
- **Lombok** (réduction du code boilerplate)  
- **Swagger/OpenAPI** (documentation automatique de l’API REST)  

### Frontend  
- **Angular** (framework SPA)  
- **TypeScript** (langage typé pour JavaScript)  
- **PrimeNG** (bibliothèque UI Angular)  
- **HTML5 & CSS3**

---

## Implémentation

### Backend (Spring Boot)

L’architecture backend suit le modèle classique MVC (Modèle-Vue-Contrôleur) adapté aux API REST.

#### 1. Entités principales

- **Client** : Représente un client de la banque avec ses informations personnelles.  
- **Compte** : Représente un compte bancaire, lié à un client, avec un solde et un statut.  
- **Operation** : Représente une transaction (crédit, débit, virement) liée à un compte.

#### 2. Exemple de DTO pour crédit

```java
@Data
public class CreditDTO {
    private String accountId;
    private double amount;
    private String description;
}
