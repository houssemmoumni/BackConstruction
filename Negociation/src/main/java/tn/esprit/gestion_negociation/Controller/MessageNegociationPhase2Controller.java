package tn.esprit.gestion_negociation.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_negociation.Entity.MessageNegociation;
import tn.esprit.gestion_negociation.Service.MessageNegociationService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/phase2/negociations/{negociationId}/messages")
public class MessageNegociationPhase2Controller {

    @Autowired
    private MessageNegociationService messageNegociationService;


    @PostMapping
    public ResponseEntity<MessageNegociation> envoyerMessagePhase2(
            @PathVariable Long negociationId,
            @RequestBody MessageNegociation message) {

        message.getNegociation().setId(negociationId);
        MessageNegociation sentMessage = messageNegociationService.envoyerMessage(message);
        return ResponseEntity.ok(sentMessage);
    }


    @GetMapping
    public ResponseEntity<List<MessageNegociation>> listerMessagesPhase2(@PathVariable Long negociationId) {
        List<MessageNegociation> messages = messageNegociationService.listerMessagesParNegociation(negociationId);
        return ResponseEntity.ok(messages);
    }
}