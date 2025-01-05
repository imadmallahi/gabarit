package fr.tdf.gdpa.gabarit.domain.models;

import fr.tdf.gdpa.gabarit.infra.entities.Activite;
import fr.tdf.gdpa.gabarit.infra.enumuration.TypeTacheEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDom {

    @Id
    private ObjectId id;
    private String nomProjet ;
    private String file;
    private List<ActiviteDom> activites;
    private Date creationDate;
}
