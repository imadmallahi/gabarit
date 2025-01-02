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
@Document(collection = "projet")
public  class Projet {

    @Id
    private Long id;
    private Long ordrePresentation;
    private String nomCourt;
    private String NomTache;
    private String nomTachePortail ;
    private TypeTacheEnum typeTache;
    private String rattacheJalon ;
    private String responsable ;
    private String acteur ;
    private String precedentJalon ;
    private Long delaisSimple ;
    private Long delaisComplexe ;
    private String tacheFermer ;
    private String jalonActive;
    private String typeActivite;



}
