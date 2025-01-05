package fr.tdf.gdpa.gabarit.infra.clients;

import fr.tdf.gdpa.gabarit.domain.spi.ProjetSpi;
import fr.tdf.gdpa.gabarit.infra.entities.Projet;
import fr.tdf.gdpa.gabarit.infra.repository.ProjetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjetSpiImpl implements ProjetSpi {

    private ProjetRepository projetRepository;

    @Override
    public Boolean saveProjet(Projet projet) {
        projetRepository.save(projet);
        return true;
    }
}
