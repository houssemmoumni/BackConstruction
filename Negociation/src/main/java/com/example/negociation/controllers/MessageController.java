package com.example.negociation.controllers;

import com.example.negociation.entities.MessageNegociation;
import com.example.negociation.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MessageController(MessageService messageService, SimpMessagingTemplate messagingTemplate) {
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping
    public ResponseEntity<MessageNegociation> sendMessage(@RequestBody MessageNegociation message) {
        // Save and send in real-time
        MessageNegociation saved = messageService.save(message);
        messagingTemplate.convertAndSend(
                "/topic/negociation/" + saved.getNegociation().getId(),
                saved
        );
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<MessageNegociation>> findAll() {
        return ResponseEntity.ok(messageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageNegociation> findById(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageNegociation> update(@PathVariable Long id, @RequestBody MessageNegociation message) {
        message.setId(id);
        return ResponseEntity.ok(messageService.update(message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}