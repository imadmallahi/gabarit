package fr.tdf.gdpa.gabarit.infra.entities;

import fr.tdf.gdpa.gabarit.infra.enumuration.TypeTacheEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "projet")
public  class Projet {

    @Id
    private ObjectId id;
    private String nomProjet ;
    private String file;
    private List<Activite> activites =new ArrayList<>(); ;
    private Date creationDate;





}
