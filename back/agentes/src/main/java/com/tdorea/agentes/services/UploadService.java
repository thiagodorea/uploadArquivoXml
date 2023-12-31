package com.tdorea.agentes.services;

import com.tdorea.agentes.dto.AgentesDto;
import com.tdorea.agentes.entities.Agentes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
@Service
public class UploadService {
    @Autowired
    private AgentesService agentesService;

    final Path root = Paths.get("uploads");

    @Transactional
    public String salvaArquivo(MultipartFile file) throws RuntimeException{
        if(!Objects.equals(file.getContentType(), "application/xml"))
            throw new RuntimeException("Arquivo Inválido");

        try{
            iniciaDiretorio();
            salvaArquivoNoDiretorio(file);
            JAXBContext jaxbContext = JAXBContext.newInstance(Agentes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File xmlFile = new File(carregaArquivoDoDiretorio(file.getOriginalFilename()).getAbsoluteFile().toString());
            Agentes agentes = (Agentes) unmarshaller.unmarshal(xmlFile);
            deletaArquivoNoDiretorio(file.getOriginalFilename());
            agentes.getAgente().forEach(agente -> System.out.println("agente codigo: " + agente.getCodigo()));
            agentesService.salvaAgentes(new AgentesDto(agentes));
            return "Arquivo " + file.getOriginalFilename() + " salvo com sucesso.";
        }catch (Exception e){
            log.error("Erro ao salvar dados: Error " + e);
            throw new RuntimeException ("Erro ao salvar dados.");
        }
    }

    private void iniciaDiretorio() throws RuntimeException{
        if (Files.notExists(this.root, LinkOption.NOFOLLOW_LINKS)) {
            try {

                Files.createDirectory(this.root);
            } catch (IOException e) {
                throw new RuntimeException("Não foi possível inicializar a diretorio para upload! " + e);
            }
        }
    }

    private void salvaArquivoNoDiretorio(MultipartFile file) throws RuntimeException{
        if(Files.notExists(this.root.resolve(file.getOriginalFilename()))) {
            try {
                Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            } catch (Exception e) {
                throw new RuntimeException("Não foi possível armazenar o arquivo. Error: " + e.getMessage());
            }
        }
    }

    private File carregaArquivoDoDiretorio(String filename) throws RuntimeException {
        try {
            Path file = this.root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource.getFile();
            } else {
                throw new RuntimeException("Não foi possível ler o arquivo!");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    private void deletaArquivoNoDiretorio(String filename) {
        try {
            if (Files.deleteIfExists(this.root.resolve(filename))) {
                log.info("O arquivo foi excluído com sucesso.");
            } else {
                log.error("A exclusão do arquivo falhou. Arquivo não localizado.");
            }
        }
        catch (IOException e) {
            log.error("A exclusão do arquivo falhou. Error:" + e);
        }
    }

}
