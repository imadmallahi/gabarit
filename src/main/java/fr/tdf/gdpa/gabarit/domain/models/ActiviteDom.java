package fr.tdf.gdpa.gabarit.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiviteDom {

    @Id
    private Long id;
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
