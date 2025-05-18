package com.bank.digital_bankiing.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACCOUNT_TYPE", length = 20)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BankAccount {

    @Id
    private String id; // UUID ou identifiant unique

    private double balance;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private String status; // ex: ACTIVE, SUSPENDED, CLOSED

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY)
    private List<AccountOperation> operations;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // Si tu veux, tu peux ajouter des méthodes métier ici
}
