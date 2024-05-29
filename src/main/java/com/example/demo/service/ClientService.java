package com.example.demo.service;

import com.example.demo.repository.ClientRepository;
import com.example.demo.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
