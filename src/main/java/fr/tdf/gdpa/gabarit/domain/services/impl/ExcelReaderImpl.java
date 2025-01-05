package fr.tdf.gdpa.gabarit.domain.services.impl;

import fr.tdf.gdpa.gabarit.domain.mappers.ProjetDomMapper;
import fr.tdf.gdpa.gabarit.domain.mappers.ProjetDomMapperImpl;
import fr.tdf.gdpa.gabarit.domain.models.ActiviteDom;
import fr.tdf.gdpa.gabarit.domain.models.ProjetDom;
import fr.tdf.gdpa.gabarit.domain.services.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import fr.tdf.gdpa.gabarit.domain.spi.ProjetSpi;
import fr.tdf.gdpa.gabarit.infra.entities.Activite;
import fr.tdf.gdpa.gabarit.infra.entities.Projet;
import fr.tdf.gdpa.gabarit.infra.repository.ProjetRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelReaderImpl implements ExcelReader {

    private static final String DEFAULT_NULL_VALUE = "";
    private static final String UNKNOWN_CELL_TYPE = "UNKNOWN";
    private static final int START_ROW_INDEX = 6;
    private ProjetSpi projetSpi;

    private ProjetDomMapper projetDomMapper;
    @Autowired
    private ProjetRepository projetRepository;

    //  private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class); // Logger


    @Override
    public Projet readExcelFile(File file) {
        Projet projet = new Projet();

        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = WorkbookFactory.create(fis);

            IntStream.range(0, workbook.getNumberOfSheets())
                    .mapToObj(workbook::getSheetAt)
                    .forEach(sheet -> {
                        //            logger.info("Lecture de la feuille : " + sheet.getSheetName());
                        List<Activite> activiteDoms = processSheet(sheet);
                        projet.setNomProjet(sheet.getSheetName());
                        projet.setActivites(processSheet(sheet));
                    });

        } catch (Exception e) {
            System.err.println("Erreur lors de la lecture du fichier Excel : " + e.getMessage());
        }

        //    projetSpi.saveProjet(projet);
        projetRepository.save(projet);

        return projet;
    }

    private List<Activite> processSheet(Sheet sheet) {
        if (sheet == null || isSheetEmpty(sheet)) {
            //   logger.info("La feuille est vide : " + sheet.getSheetName());
            return List.of();
        }

        //  logger.info("Dernière ligne non vide : " + getLastNonEmptyRowNum(sheet));

        return IntStream.rangeClosed(START_ROW_INDEX, getLastNonEmptyRowNum(sheet))
                .mapToObj(sheet::getRow)
                .filter(ExcelReaderImpl::isRowEmpty)
                .map(this::mapRowToActiviteDom)
                .filter(activiteDom -> activiteDom != null)
                .toList();
    }

    private boolean isSheetEmpty(Sheet sheet) {
        return sheet.getLastRowNum() == 0 && sheet.getRow(0) == null;
    }


    private Activite mapRowToActiviteDom(Row row) {
        Activite activiteDom = new Activite();
        activiteDom.setOrdrePresentation(processCell(row.getCell(0)));
        activiteDom.setNomCourt(processCell(row.getCell(1)));
        activiteDom.setNomTache(processCell(row.getCell(2)));
        activiteDom.setNomTachePortail(processCell(row.getCell(3)));
        activiteDom.setTypeTache(processCell(row.getCell(4)));
        activiteDom.setRattacheJalon(processCell(row.getCell(5)));
        activiteDom.setResponsable(processCell(row.getCell(6)));
        activiteDom.setActeur(processCell(row.getCell(7)));
        activiteDom.setPrecedentJalon(processCell(row.getCell(8)));
        activiteDom.setDelaisSimple(processCell(row.getCell(9)));
        activiteDom.setDelaisComplexe(processCell(row.getCell(10)));
        activiteDom.setTacheFermer(processCell(row.getCell(11)));
        activiteDom.setJalonActive(processCell(row.getCell(12)));
        activiteDom.setTypeActivite(processCell(row.getCell(13)));
        return activiteDom;
    }

    public static int getLastNonEmptyRowNum(Sheet sheet) {

        return IntStream.rangeClosed(0, sheet.getLastRowNum()) // Create a stream of row indices
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a)) // Sort in descending order
                .filter(i -> {
                    return isRowEmpty(sheet.getRow(i)); // Filter non-empty rows
                })
                .findFirst()
                .orElse(-1);
    }

    private static boolean isRowEmpty(Row row) {
        if (row == null) {
            return false;
        }
        return !IntStream.range(row.getFirstCellNum(), row.getLastCellNum())
                .mapToObj(row::getCell)
                .allMatch(cell -> cell == null || cell.getCellType() == CellType.BLANK);
    }


    private void processRow(Row row) {

        Stream.of(row)
                .flatMap(r -> Stream.of(r.cellIterator()))
                .flatMap(cellIterator -> Stream.generate(cellIterator::next)
                        .limit(row.getLastCellNum()))
                .forEach(this::processCell);
    }


    private String processCell(Cell cell) {
        if (Objects.isNull(cell)) {
            return DEFAULT_NULL_VALUE;
        }

        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();

            case NUMERIC -> processNumericCell(cell);

            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());

            case FORMULA -> processFormulaCell(cell);

            case BLANK -> DEFAULT_NULL_VALUE;

            default -> UNKNOWN_CELL_TYPE;
        };
    }

    private String processNumericCell(Cell cell) {
        if (DateUtil.isCellDateFormatted(cell)) {
            return cell.getDateCellValue().toString();
        } else {
            return String.valueOf(cell.getNumericCellValue());
        }
    }

    private String processFormulaCell(Cell cell) {
        try {
            return cell.getCellFormula();
        } catch (Exception e) {
            return UNKNOWN_CELL_TYPE;
        }
    }


}

