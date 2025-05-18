package com.bank.digital_bankiing.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("CURRENT_ACCOUNT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount extends BankAccount {
    private double overdraft;
}
