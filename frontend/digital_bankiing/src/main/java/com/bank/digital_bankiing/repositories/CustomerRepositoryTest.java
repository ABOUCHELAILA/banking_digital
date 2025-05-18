package com.bank.digital_bankiing.repositories;

import com.bank.digital_bankiing.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest  // Charge le contexte Spring pour les tests
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;  // Injection du repository

    // Test de l'ajout d'un Customer
    @Test
    void testSaveCustomer() {
        // Créer un Customer
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("123456789");

        // Sauvegarder dans la base de données
        Customer savedCustomer = customerRepository.save(customer);

        // Vérifier que l'ID a bien été généré
        assertNotNull(savedCustomer.getId());
        assertEquals("John Doe", savedCustomer.getName());  // Vérifier le nom
        assertEquals("john.doe@example.com", savedCustomer.getEmail());  // Vérifier l'email
    }

    // Test de la lecture d'un Customer par ID
    @Test
    void testGetCustomerById() {
        // Créer un customer et le sauvegarder
        Customer customer = new Customer();
        customer.setName("Jane Smith");
        customer.setEmail("jane.smith@example.com");
        customer.setPhone("987654321");
        customerRepository.save(customer);

        // Lire le customer par son ID
        Customer foundCustomer = customerRepository.findById(customer.getId()).orElse(null);

        // Vérifier que le customer est bien trouvé
        assertNotNull(foundCustomer);
        assertEquals("Jane Smith", foundCustomer.getName());  // Vérifier le nom
    }

    // Test de la mise à jour d'un Customer
    @Test
    void testUpdateCustomer() {
        // Créer un customer et le sauvegarder
        Customer customer = new Customer();
        customer.setName("Sam Brown");
        customer.setEmail("sam.brown@example.com");
        customer.setPhone("123456789");
        customerRepository.save(customer);

        // Mettre à jour le nom du customer
        customer.setName("Samuel Brown");
        customerRepository.save(customer);

        // Vérifier que le customer a été mis à jour
        Customer updatedCustomer = customerRepository.findById(customer.getId()).orElse(null);
        assertNotNull(updatedCustomer);
        assertEquals("Samuel Brown", updatedCustomer.getName());  // Vérifier le nom mis à jour
    }

    // Test de la suppression d'un Customer
    @Test
    void testDeleteCustomer() {
        // Créer un customer et le sauvegarder
        Customer customer = new Customer();
        customer.setName("Mike Johnson");
        customer.setEmail("mike.johnson@example.com");
        customer.setPhone("111222333");
        customerRepository.save(customer);

        // Supprimer le customer
        customerRepository.deleteById(customer.getId());

        // Vérifier que le customer a bien été supprimé
        Customer deletedCustomer = customerRepository.findById(customer.getId()).orElse(null);
        assertNull(deletedCustomer);  // Le customer ne doit plus exister
    }
}
