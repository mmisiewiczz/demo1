package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Product;
import com.example.demo.model.Order;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.OrderRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class CSVExportService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void writeClientsToCsv(Writer writer) throws IOException {
        List<Client> clients = clientRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Client client : clients) {
                csvPrinter.printRecord(client.getId(), client.getFirstName(), client.getLastName(), client.getEmail(), client.getPhoneNumber());
            }
        }
    }

    public void writeProductsToCsv(Writer writer) throws IOException {
        List<Product> products = productRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Product product : products) {
                csvPrinter.printRecord(product.getId(), product.getName(), product.getDescription());
            }
        }
    }

    public void writeOrdersToCsv(Writer writer) throws IOException {
        List<Order> orders = orderRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Order order : orders) {
                csvPrinter.printRecord(
                    order.getId(), 
                    //to działa jak mamy połączenie z klientem
                   // order.getClient().getId(), 
                   // order.getClient().getFirstName(), 
                   // order.getClient().getLastName(), 
                    order.getOrderDate(),
                    order.getProduct().getId(), 
                    order.getProduct().getName(), 
                    order.getProduct().getDescription()
                );
            }
        }
    }
}
