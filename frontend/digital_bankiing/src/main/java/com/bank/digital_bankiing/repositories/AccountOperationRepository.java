package com.bank.digital_bankiing.repositories;

import com.bank.digital_bankiing.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
