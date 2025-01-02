package fr.tdf.gdpa.gabarit.domain.models;

import fr.tdf.gdpa.gabarit.infra.enumuration.TypeTacheEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDom {

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
