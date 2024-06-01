package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_order")
public class Order {

    /* wersja 1 klient do wielu zamówień i wielu produktów
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    private Date orderDate;
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*połączenie z klientem */
/* 
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
*/
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Date orderDate;
}