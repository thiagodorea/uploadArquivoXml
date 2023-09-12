package com.tdorea.agentes.controlles;

import com.tdorea.agentes.services.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;


@Slf4j
@RestController
@RequestMapping(value = "upload", produces = {"application/json"})
public class UploadController {

    @Autowired
    private UploadService uploadService ;

    @PostMapping(value = "v1/xml" )
    public ResponseEntity<String> salvaArquivoXml(@RequestParam("arquivo") MultipartFile file) throws JAXBException, Exception{
        try{
            log.info("Recebendo o arquivo: " + file.getOriginalFilename() + " Tipo de arquivo: " + file.getContentType());
            return new ResponseEntity<>(uploadService.salvaArquivo(file), HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Erro ao processar o arquivo", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
