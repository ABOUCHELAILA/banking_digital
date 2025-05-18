package com.bank.digital_bankiing.controllers;

import com.bank.digital_bankiing.entities.BankAccount;
import com.bank.digital_bankiing.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    // Récupérer tous les comptes
    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    // Récupérer un compte par ID
    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable String id) {
        return bankAccountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un nouveau compte
    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.saveAccount(bankAccount);
    }

    // Mettre à jour un compte existant
    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> updateAccount(@PathVariable String id, @RequestBody BankAccount accountDetails) {
        return bankAccountService.getAccountById(id)
                .map(account -> {
                    account.setBalance(accountDetails.getBalance());
                    account.setStatus(accountDetails.getStatus());
                    // Mettre à jour d'autres champs si nécessaire
                    BankAccount updated = bankAccountService.saveAccount(account);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un compte
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable String id) {
        return bankAccountService.getAccountById(id)
                .map(account -> {
                    bankAccountService.deleteAccount(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
