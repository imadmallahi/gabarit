package fr.tdf.gdpa.gabarit.infra.entities;

import fr.tdf.gdpa.gabarit.infra.enumuration.TypeTacheEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "activite")
public  class Activite  {

    @Id
    private String id;
    private String ordrePresentation;
    private String nomCourt;
    private String NomTache;
    private String nomTachePortail ;
    private String typeTache;
    private String rattacheJalon ;
    private String responsable ;
    private String acteur ;
    private String precedentJalon ;
    private String delaisSimple ;
    private String delaisComplexe ;
    private String tacheFermer ;
    private String jalonActive;
    private String typeActivite;
}
