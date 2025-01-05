package fr.tdf.gdpa.gabarit.domain.mappers;

import fr.tdf.gdpa.gabarit.domain.models.ActiviteDom;
import fr.tdf.gdpa.gabarit.infra.entities.Activite;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "ActiviteDomMapperImpl")
public interface ActiviteDomMapper {
    Activite toActivite(ActiviteDom activiteDom);
    ActiviteDom toActiviteDom(Activite activite);
    List<ActiviteDom> toActiviteDomList(List<Activite> activites);
    List<Activite> toActiviteList(List<ActiviteDom> activiteDoms);
}
