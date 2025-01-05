package fr.tdf.gdpa.gabarit.app.mappers;

import fr.tdf.gdpa.gabarit.domain.models.ActiviteDom;
import fr.tdf.gdpa.gabarit.infra.entities.Activite;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ActiviteMapperImpl")
public interface ActiviteMapper {
    ActiviteDom toActiviteDom(Activite activite);
    Activite toActivite(ActiviteDom activiteDom);
}
