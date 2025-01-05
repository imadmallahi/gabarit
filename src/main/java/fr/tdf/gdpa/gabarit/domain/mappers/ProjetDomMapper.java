package fr.tdf.gdpa.gabarit.domain.mappers;

import fr.tdf.gdpa.gabarit.domain.models.ProjetDom;
import fr.tdf.gdpa.gabarit.infra.entities.Projet;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ProjetDomMapperImpl")
public interface ProjetDomMapper {

    Projet toProjet(ProjetDom projetDom);
    ProjetDom toProjetDom(Projet projet);
}
