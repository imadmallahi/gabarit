package fr.tdf.gdpa.gabarit.infra.clients;

import fr.tdf.gdpa.gabarit.domain.models.ProjetDom;
import fr.tdf.gdpa.gabarit.domain.spi.ExcelReaderSpi;

import java.util.List;

public class ExcelReaderSpiImpl implements ExcelReaderSpi {

    @Override
    public List<ProjetDom> readExcelFile(String fileName) {
        return List.of();
    }
}
