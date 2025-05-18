package com.bank.digital_bankiing.repositories;

import com.bank.digital_bankiing.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
