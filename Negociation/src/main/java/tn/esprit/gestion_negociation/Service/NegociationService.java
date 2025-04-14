package tn.esprit.gestion_negociation.Service;

import tn.esprit.gestion_negociation.Entity.Negociation;
import tn.esprit.gestion_negociation.Entity.NegociationLightDTO;

import java.util.List;

public interface  NegociationService {
    Negociation creerNegociation(Negociation negociation,Long id);

    Negociation getNegociationById(Long id);

    List<Negociation> listerNegociations();

    Negociation updateNegociation(Long id, Negociation negociation);

    void deleteNegociation(Long id);

    Negociation validationNegociation(Long id, boolean isValid, String comment);


    List<NegociationLightDTO> listerNegociationsLight();
    public NegociationLightDTO getNegociationLightById(Long id);
}
