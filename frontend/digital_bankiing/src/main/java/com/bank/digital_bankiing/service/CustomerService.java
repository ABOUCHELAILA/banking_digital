package com.bank.digital_bankiing.service;

import com.bank.digital_bankiing.entities.Customer;
import com.bank.digital_bankiing.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    // Injection du repository via constructeur (recommandé)
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Récupérer la liste de tous les clients
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Rechercher un client par son ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Ajouter ou modifier un client
    public Customer saveCustomer(Customer customer) {
        // Ici tu peux ajouter des règles métier avant la sauvegarde
        return customerRepository.save(customer);
    }

    // Supprimer un client par son ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

