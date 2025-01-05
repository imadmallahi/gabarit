package fr.tdf.gdpa.gabarit.app.resources;


import fr.tdf.gdpa.gabarit.domain.models.ProjetDom;
import fr.tdf.gdpa.gabarit.domain.services.ExcelReader;
import fr.tdf.gdpa.gabarit.infra.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileResource {

    @Autowired
    private ExcelReader excelReader;


    @PostMapping("/upload")
    public Projet uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
        file.transferTo(tempFile);

        return excelReader.readExcelFile(tempFile);






    }
}
