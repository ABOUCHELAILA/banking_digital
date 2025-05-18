package com.bank.digital_bankiing.service;

import com.bank.digital_bankiing.entities.BankAccount;
import com.bank.digital_bankiing.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> getAccountById(String id) {
        return bankAccountRepository.findById(id);
    }

    public BankAccount saveAccount(BankAccount bankAccount) {
        // Ici tu peux ajouter la logique métier (ex: validation, génération ID)
        return bankAccountRepository.save(bankAccount);
    }

    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
