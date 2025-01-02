package fr.tdf.gdpa.gabarit.app.resources;


import fr.tdf.gdpa.gabarit.domain.services.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileResource {

    @Autowired
    private ExcelReader excelReader;


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        // Convert MultipartFile to File


        File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
        file.transferTo(tempFile);

        excelReader.readExcelFile(tempFile).toString();

        return tempFile.getAbsolutePath();




    }
}
