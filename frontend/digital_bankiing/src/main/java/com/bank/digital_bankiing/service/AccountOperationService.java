package com.bank.digital_bankiing.service;

import com.bank.digital_bankiing.entities.AccountOperation;
import com.bank.digital_bankiing.repositories.AccountOperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountOperationService {

    private final AccountOperationRepository accountOperationRepository;

    public AccountOperationService(AccountOperationRepository accountOperationRepository) {
        this.accountOperationRepository = accountOperationRepository;
    }

    public List<AccountOperation> getAllOperations() {
        return accountOperationRepository.findAll();
    }

    public Optional<AccountOperation> getOperationById(Long id) {
        return accountOperationRepository.findById(id);
    }

    public AccountOperation saveOperation(AccountOperation accountOperation) {
        // Ajouter logique métier ici si besoin (ex: validation montant)
        return accountOperationRepository.save(accountOperation);
    }

    public void deleteOperation(Long id) {
        accountOperationRepository.deleteById(id);
    }
}
