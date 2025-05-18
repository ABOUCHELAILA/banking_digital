package com.bank.digital_bankiing.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("SAVING_ACCOUNT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingAccount extends BankAccount {
    private double interestRate;
}
