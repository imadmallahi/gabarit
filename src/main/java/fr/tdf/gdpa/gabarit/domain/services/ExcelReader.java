package fr.tdf.gdpa.gabarit.domain.services;

import fr.tdf.gdpa.gabarit.domain.models.ProjetDom;
import fr.tdf.gdpa.gabarit.infra.entities.Projet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ExcelReader {

    List<ProjetDom> readExcelFile(File file) throws IOException ;


}
