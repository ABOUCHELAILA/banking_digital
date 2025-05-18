package com.bank.digital_bankiing.controllers;

import com.bank.digital_bankiing.entities.AccountOperation;
import com.bank.digital_bankiing.service.AccountOperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operations")
public class AccountOperationController {

    private final AccountOperationService accountOperationService;

    public AccountOperationController(AccountOperationService accountOperationService) {
        this.accountOperationService = accountOperationService;
    }

    // Récupérer toutes les opérations
    @GetMapping
    public List<AccountOperation> getAllOperations() {
        return accountOperationService.getAllOperations();
    }

    // Récupérer une opération par ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountOperation> getOperationById(@PathVariable Long id) {
        return accountOperationService.getOperationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer une nouvelle opération (débit ou crédit)
    @PostMapping
    public AccountOperation createOperation(@RequestBody AccountOperation operation) {
        return accountOperationService.saveOperation(operation);
    }

    // Mettre à jour une opération existante
    @PutMapping("/{id}")
    public ResponseEntity<AccountOperation> updateOperation(@PathVariable Long id, @RequestBody AccountOperation operationDetails) {
        return accountOperationService.getOperationById(id)
                .map(operation -> {
                    operation.setAmount(operationDetails.getAmount());
                    operation.setDescription(operationDetails.getDescription());
                    operation.setType(operationDetails.getType());
                    // Mettre à jour d’autres champs si besoin
                    AccountOperation updated = accountOperationService.saveOperation(operation);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer une opération
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOperation(@PathVariable Long id) {
        return accountOperationService.getOperationById(id)
                .map(operation -> {
                    accountOperationService.deleteOperation(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
