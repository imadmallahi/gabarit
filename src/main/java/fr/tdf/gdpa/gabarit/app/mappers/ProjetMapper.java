package fr.tdf.gdpa.gabarit.app.mappers;

import fr.tdf.gdpa.gabarit.app.dto.ProjetDto;
import fr.tdf.gdpa.gabarit.domain.models.ProjetDom;
import fr.tdf.gdpa.gabarit.infra.entities.Projet;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(implementationName = "ProjetMapperImpl")
public interface ProjetMapper {

    ProjetDom toProjetDom(ProjetDto projetDto);
    ProjetDto toProjetDto(ProjetDom projetDom);
}
