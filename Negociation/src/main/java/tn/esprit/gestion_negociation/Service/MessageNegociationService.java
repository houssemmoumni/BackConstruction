package tn.esprit.gestion_negociation.Service;

import tn.esprit.gestion_negociation.Entity.MessageNegociation;

import java.util.List;

public interface MessageNegociationService {
    MessageNegociation envoyerMessage(MessageNegociation message);
    List<MessageNegociation> listerMessagesParNegociation(Long negociationId);
}