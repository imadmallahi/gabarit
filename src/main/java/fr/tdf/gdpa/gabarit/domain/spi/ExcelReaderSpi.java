package fr.tdf.gdpa.gabarit.domain.spi;

import fr.tdf.gdpa.gabarit.domain.models.ProjetDom;

import java.util.List;

public interface ExcelReaderSpi {

    List<ProjetDom> readExcelFile(String fileName) ;

}
