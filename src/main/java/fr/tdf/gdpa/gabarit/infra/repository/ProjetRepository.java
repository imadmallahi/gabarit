package fr.tdf.gdpa.gabarit.infra.repository;

import fr.tdf.gdpa.gabarit.infra.entities.Projet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends MongoRepository<Projet, Long> {
}
