package com.example.negociation.services;

import com.example.negociation.entities.MessageNegociation;
import com.example.negociation.repositories.MessageNegociationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageNegociationRepository repository;

    @Autowired
    public MessageService(MessageNegociationRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MessageNegociation save(MessageNegociation message) {
        message.setDateEnvoi(LocalDateTime.now());
        return repository.save(message);
    }

    public List<MessageNegociation> findAll() {
        return repository.findAll();
    }

    public MessageNegociation findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public MessageNegociation update(MessageNegociation message) {
        return repository.save(message);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}