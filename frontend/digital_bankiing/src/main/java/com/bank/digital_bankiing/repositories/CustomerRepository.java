package com.bank.digital_bankiing.repositories;

import com.bank.digital_bankiing.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

