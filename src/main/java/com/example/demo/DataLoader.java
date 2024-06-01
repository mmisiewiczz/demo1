package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        Client client1 = clientRepository.save(new Client(null, "Jan", "Kowalski", "jan.kowalski@example.com", "123456789"));
        Client client2 = clientRepository.save(new Client(null, "Anna", "Nowak", "anna.nowak@example.com", "987654321"));
        Client client3 = clientRepository.save(new Client(null, "Piotr", "Wiśniewski", "piotr.wisniewski@example.com", "564738291"));
        Client client4 = clientRepository.save(new Client(null, "Marta", "Zielińska", "marta.zielinska@example.com", "192837465"));
        Client client5 = clientRepository.save(new Client(null, "Tomasz", "Kozłowski", "tomasz.kozlowski@example.com", "837261495"));

        // Zapis produktów
        Product product1 = productRepository.save(new Product(null, "Product1", "Description1"));
        Product product2 = productRepository.save(new Product(null, "Product2", "Description2"));
        Product product3 = productRepository.save(new Product(null, "Product3", "Description3"));
        Product product4 = productRepository.save(new Product(null, "Product4", "Description4"));
        Product product5 = productRepository.save(new Product(null, "Product5", "Description5"));

        // Zapis zamówień
        orderRepository.save(new Order(null, product1, new Date()));
        orderRepository.save(new Order(null, product2, new Date()));
        orderRepository.save(new Order(null, product3, new Date()));
        orderRepository.save(new Order(null, product4, new Date()));
        orderRepository.save(new Order(null, product5, new Date()));
    }
}

        /*wersja z listą 
        // Zapis produktów
        Product product1 = productRepository.save(new Product(null, "Product1", "Description1"));
        Product product2 = productRepository.save(new Product(null, "Product2", "Description2"));
        Product product3 = productRepository.save(new Product(null, "Product3", "Description3"));
        Product product4 = productRepository.save(new Product(null, "Product4", "Description4"));
        Product product5 = productRepository.save(new Product(null, "Product5", "Description5"));

        // Zapis zamówień
        orderRepository.save(new Order(null, client1, Arrays.asList(product1, product2), new Date()));
        orderRepository.save(new Order(null, client2, Arrays.asList(product2, product3), new Date()));
        orderRepository.save(new Order(null, client3, Arrays.asList(product3, product4), new Date()));
        orderRepository.save(new Order(null, client4, Arrays.asList(product4, product5), new Date()));
        orderRepository.save(new Order(null, client5, Arrays.asList(product1, product5), new Date()));
    }
    */
