package fr.tdf.gdpa.gabarit;

import fr.tdf.gdpa.gabarit.domain.services.ExcelReader;
import fr.tdf.gdpa.gabarit.infra.entities.Activite;
import fr.tdf.gdpa.gabarit.infra.entities.Projet;
import fr.tdf.gdpa.gabarit.infra.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class GabaritApplication implements CommandLineRunner  {

	@Autowired
	private ProjetRepository projetRepository;

	@Autowired
	private ExcelReader excelReader;


	public static void main(String[] args) {

		SpringApplication.run(GabaritApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Projet projet = new Projet();
		//projet.setId(1L);
		Activite activite = new Activite();
		activite.setId("1");
		activite.setActeur("Imad");
		projet.getActivites().add(activite);


		projetRepository.save(projet);

		//excelReader.readExcelFile("/Users/macbook/Downloads/gabarit/src/main/resources/static/Test.xls");
	}

}
