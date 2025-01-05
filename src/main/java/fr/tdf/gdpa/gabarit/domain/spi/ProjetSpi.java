package fr.tdf.gdpa.gabarit.domain.spi;

import fr.tdf.gdpa.gabarit.infra.entities.Projet;

public interface ProjetSpi {
    Boolean saveProjet(Projet projet);
}
