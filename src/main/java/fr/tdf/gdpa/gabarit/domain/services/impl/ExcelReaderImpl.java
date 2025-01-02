package fr.tdf.gdpa.gabarit.domain.services.impl;

import fr.tdf.gdpa.gabarit.domain.models.ProjetDom;
import fr.tdf.gdpa.gabarit.domain.services.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelReaderImpl implements ExcelReader {

    @Override
    public List<ProjetDom> readExcelFile(File file) {

            try (FileInputStream fis = new FileInputStream(file)) {
                Workbook workbook;
                if (file.getName().endsWith(".xlsx")) {
                    workbook = new XSSFWorkbook(fis);
                } else if (file.getName().endsWith(".xls")) {
                    workbook = new HSSFWorkbook(fis);
                } else {
                    throw new IllegalArgumentException("The specified file is not an Excel file");
                }

                // Iterate through sheets
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    Sheet sheet = workbook.getSheetAt(i);
                    System.out.println("Reading Sheet: " + sheet.getSheetName());

                    // Start reading from row index 5 (6th row)
                    for (int rowIndex = 5; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                        Row row = sheet.getRow(rowIndex);
                        if (row == null) continue; // Skip null rows

                        for (Cell cell : row) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    System.out.print(cell.getStringCellValue() + "\t");
                                    break;
                                case NUMERIC:
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        System.out.print(cell.getDateCellValue() + "\t");
                                    } else {
                                        System.out.print(cell.getNumericCellValue() + "\t");
                                    }
                                    break;
                                case BOOLEAN:
                                    System.out.print(cell.getBooleanCellValue() + "\t");
                                    break;
                                case FORMULA:
                                    System.out.print(cell.getCellFormula() + "\t");
                                    break;
                                default:
                                    System.out.print("UNKNOWN\t");
                                    break;
                            }
                        }
                        System.out.println();
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        return null;
    }


    private void processRow(Row row) {
        // Stream cells in a row
        Stream.of(row)
                .flatMap(r -> Stream.of(r.cellIterator()))
                .flatMap(cellIterator -> Stream.generate(cellIterator::next)
                        .limit(row.getLastCellNum()))
                .forEach(cell -> processCell(cell));
    }

    private void processCell(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                System.out.print(cell.getStringCellValue() + "\t");
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue() + "\t");
                } else {
                    System.out.print(cell.getNumericCellValue() + "\t");
                }
                break;
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue() + "\t");
                break;
            case FORMULA:
                System.out.print(cell.getCellFormula() + "\t");
                break;
            default:
                System.out.print("UNKNOWN\t");
                break;
        }
    }
}

