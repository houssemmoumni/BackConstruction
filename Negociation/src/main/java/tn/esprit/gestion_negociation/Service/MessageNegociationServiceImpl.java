package tn.esprit.gestion_negociation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_negociation.Entity.MessageNegociation;
import tn.esprit.gestion_negociation.Repository.MessageNegociationRepository;

import java.util.List;

@Service
public class MessageNegociationServiceImpl implements MessageNegociationService {

    @Autowired
    private MessageNegociationRepository messageNegociationRepository;

    @Override
    public MessageNegociation envoyerMessage(MessageNegociation message) {
        return messageNegociationRepository.save(message);
    }

    @Override
    public List<MessageNegociation> listerMessagesParNegociation(Long negociationId) {
        return messageNegociationRepository.findByNegociationId(negociationId);
    }
}