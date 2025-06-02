 Application de Banque Digitale  
*Rapport Technique Détaillé*

---

## Table des matières
- [Introduction](#introduction)  
- [Architecture du Projet](#architecture-du-projet)  
- [Technologies Utilisées](#technologies-utilisées)  
- [Implémentation](#implémentation)  
  - [Backend (Spring Boot)](#backend-spring-boot)  
  - [Frontend (Angular)](#frontend-angular)  
- [Fonctionnalités](#fonctionnalités)  
- [Exemples de Code Commentés](#exemples-de-code-commentés)  
- [Sécurité](#sécurité)  
- [Tests et Validation](#tests-et-validation)  
- [Déploiement](#déploiement)  
- [Captures d'écran](#captures-décran)  
- [Conclusion et Perspectives](#conclusion-et-perspectives)

---

## Introduction

L’application de banque digitale vise à fournir une solution moderne, sécurisée et efficace pour gérer les opérations bancaires courantes : gestion des clients, gestion des comptes, et traitement des transactions.  

Le projet s’appuie sur une architecture client-serveur moderne :  
- Backend REST API avec Spring Boot, pour une gestion robuste des données et de la logique métier.  
- Frontend en Angular, pour une expérience utilisateur fluide et dynamique.  

L’objectif principal est de concevoir une application modulable, scalable et maintenable, pouvant être facilement étendue pour intégrer de nouvelles fonctionnalités.

---

## Architecture du Projet

### Vue d’ensemble

L’architecture suit le modèle classique **3 tiers** :  

- **Présentation (Frontend Angular)** : interaction avec l’utilisateur, affichage, collecte des données  
- **Logique métier (Backend Spring Boot)** : règles métier, validation, gestion des erreurs  
- **Persistance (Base de données MySQL)** : stockage durable des données  

Les échanges entre frontend et backend se font via une API REST sécurisée avec JWT.

### Structure Backend

```plaintext
backend/
├── src/
│   ├── main/
│   │   ├── java/com/banque/ (code source Java)
│   │   └── resources/ (configuration, application.properties)
└── pom.xml (gestion des dépendances Maven)
Structure Frontend
plaintext
Copier
Modifier
frontend/
├── src/
│   ├── app/ (composants Angular)
│   ├── assets/ (images, styles)
│   └── environments/ (configs pour dev/prod)
└── package.json (gestion des dépendances npm)
Technologies Utilisées
Backend
Java 17 : langage moderne, performant

Spring Boot 3.4.5 : framework pour API REST rapide à développer

Spring Data JPA : simplifie les accès aux données avec ORM Hibernate

MySQL : base relationnelle robuste

Lombok : annotations pour réduire le code répétitif (getters/setters)

Swagger/OpenAPI : documentation automatique et interactive des API REST

JWT : authentification et autorisation sécurisée

Frontend
Angular 15+ : framework SPA structuré et performant

TypeScript : typage statique pour plus de robustesse

PrimeNG : composants UI modernes (tables, dialogues, boutons)

RxJS : gestion des flux de données asynchrones

Bootstrap / CSS3 : mise en forme responsive

Implémentation
Backend (Spring Boot)
1. Modèle de données
Client

java
Copier
Modifier
@Entity
public class Customer {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;
    // Autres champs, getters/setters via Lombok
}
Compte

java
Copier
Modifier
@Entity
public class Account {
    @Id
    private String id; // UUID ou autre identifiant unique
    private double balance;
    private LocalDateTime createdAt;
    private AccountStatus status;
    private String type;

    @ManyToOne
    private Customer customer;
}
Operation

java
Copier
Modifier
@Entity
public class Operation {
    @Id @GeneratedValue
    private Long id;
    private LocalDateTime operationDate;
    private double amount;
    private OperationType type; // DEBIT, CREDIT
    private String description;

    @ManyToOne
    private Account account;
}
2. Services métier
Gestion des opérations de crédit/débit avec validation :

java
Copier
Modifier
@Transactional
public void creditAccount(String accountId, double amount, String description) {
    Account account = accountRepository.findById(accountId)
                     .orElseThrow(() -> new AccountNotFoundException(accountId));
    account.setBalance(account.getBalance() + amount);
    accountRepository.save(account);

    Operation operation = new Operation();
    operation.setAccount(account);
    operation.setAmount(amount);
    operation.setType(OperationType.CREDIT);
    operation.setDescription(description);
    operation.setOperationDate(LocalDateTime.now());
    operationRepository.save(operation);
}
3. Contrôleurs REST
java
Copier
Modifier
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.findAll();
    }

    @PostMapping("/{id}/credit")
    public ResponseEntity<?> creditAccount(@PathVariable String id, @RequestBody CreditDTO dto) {
        accountService.creditAccount(id, dto.getAmount(), dto.getDescription());
        return ResponseEntity.ok().build();
    }
}
Frontend (Angular)
1. Structure générale
Services Angular pour consommer les API REST

Composants pour afficher listes, formulaires, dialogues modaux

Formulaires réactifs (ReactiveFormsModule) avec validations

2. Exemple de service Angular
typescript
Copier
Modifier
@Injectable({providedIn: 'root'})
export class AccountService {
  private apiUrl = 'http://localhost:8080/api/accounts';

  constructor(private http: HttpClient) {}

  getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(this.apiUrl);
  }

  creditAccount(id: string, creditDto: CreditDTO): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/${id}/credit`, creditDto);
  }
}
3. Exemple de composant
Affichage paginé des comptes :

html
Copier
Modifier
<p-table [value]="accounts" [paginator]="true" [rows]="10">
  <ng-template pTemplate="header">
    <tr><th>ID</th><th>Solde</th><th>Type</th><th>Client</th></tr>
  </ng-template>
  <ng-template pTemplate="body" let-account>
    <tr>
      <td>{{account.id}}</td>
      <td>{{account.balance | currency:'EUR'}}</td>
      <td>{{account.type}}</td>
      <td>{{account.customer.name}}</td>
    </tr>
  </ng-template>
</p-table>
Fonctionnalités
Gestion des clients : création, lecture, mise à jour, suppression

Gestion des comptes bancaires : consultation, historique, opérations

Opérations bancaires : débit, crédit, virement entre comptes

Pagination et filtrage des listes

Authentification & Autorisation avec JWT

Interface utilisateur responsive et accessible

Exemples de Code Commentés
DTO CreditDTO
java
Copier
Modifier
@Data // Lombok génère automatiquement getters/setters
public class CreditDTO {
    private String accountId;  // Identifiant du compte à créditer
    private double amount;     // Montant à créditer
    private String description; // Motif ou description de l'opération
}
Interface Account (TypeScript)
typescript
Copier
Modifier
export interface Account {
  id: string;           // Identifiant unique du compte
  balance: number;      // Solde actuel du compte
  createdAt: Date;      // Date de création du compte
  status: AccountStatus; // Statut (actif, bloqué...)
  type: string;         // Type de compte (courant, épargne...)
  customer: Customer;   // Client associé
}
Sécurité
Utilisation de JWT (JSON Web Tokens) pour sécuriser les API REST.

Gestion des rôles (admin, utilisateur) avec contrôle d’accès granulaire.

Validation côté backend et frontend des données entrantes.

Protection contre les attaques classiques (CSRF, injection SQL via ORM).

Tests et Validation
Tests unitaires sur les services backend avec JUnit et Mockito.

Tests d’intégration sur les API REST.

Tests e2e frontend avec Cypress pour vérifier les flux utilisateur.

Validation manuelle des scénarios métiers critiques.
