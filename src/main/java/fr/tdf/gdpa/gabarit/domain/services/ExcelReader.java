package fr.tdf.gdpa.gabarit.domain.services;

import fr.tdf.gdpa.gabarit.domain.models.ProjetDom;
import fr.tdf.gdpa.gabarit.infra.entities.Projet;

import java.io.File;
import java.io.IOException;

public interface ExcelReader {

    Projet readExcelFile(File file) throws IOException ;


}
