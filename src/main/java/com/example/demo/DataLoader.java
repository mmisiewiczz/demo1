package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.model.Product;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Client client1 = new Client("Jan", "Kowalski", "jan.kowalski@example.com", "123456789");
        clientRepository.save(client1);

        Client client2 = new Client("Anna", "Nowak", "anna.nowak@example.com", "987654321");
        clientRepository.save(client2);

        Product product1 = new Product("Product1", "Description1");
        productRepository.save(product1);

        Product product2 = new Product("Product2", "Description2");
        productRepository.save(product2);
    }
}
