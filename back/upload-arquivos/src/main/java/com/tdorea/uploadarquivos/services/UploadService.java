package com.tdorea.uploadarquivos.services;

import com.tdorea.uploadarquivos.dtos.AgentesDto;
import com.tdorea.uploadarquivos.entities.Agentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class UploadService {

    @Autowired
    private AgenteService agenteService;

    @Autowired
    private AgentesService agentesService;

    final Path root = Paths.get("uploads");

    @Transactional
    public String salvaArquivo(MultipartFile file) throws JAXBException, Exception {
        if(!Objects.equals(file.getContentType(), "application/xml"))
            throw new RuntimeException("Arquivo Inválido");


        iniciaDiretorio();
        salvaArquivoNoDiretorio(file);

        //Reader reader = new BufferedReader(new InputStreamReader());
        //JSONObject json = XML.toJSONObject(reader);
        //Gson gson = new Gson();
        //JSONObject agentes = json.getJSONObject("agentes");
        //JSONObject agente = agentes.getJSONObject("agente");
    //try{
        //System.out.println(agente);
        //AgenteDto agenteDto = gson.fromJson(String.valueOf(agente), AgenteDto.class);
        //System.out.println(agenteDto);
        //deletaArquivoNoDiretorio();
        //return String.valueOf(agenteService.salvaAgente(agenteDto));
        try{
            //Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            //JSONObject json = XML.toJSONObject(reader);
            //Gson gson = new Gson();
            //JSONObject agentess = json.getJSONObject("agentes");
            //System.out.println(json);
            //JSONObject agente = agentess.getJSONObject("agente");

            JAXBContext jaxbContext = JAXBContext.newInstance(Agentes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            File xmlFile = new File(carregaArquivoDoDiretorio(file.getOriginalFilename()).getAbsoluteFile().toString());

            Agentes agentes = (Agentes) unmarshaller.unmarshal(xmlFile);
            System.out.println(agentes);
            return String.valueOf(agentesService.salvaAgentes(new AgentesDto(agentes)));
        }catch (Exception e){
            throw new RuntimeException ("Erro ao salvar arquivo.");
        }
    }

    private void iniciaDiretorio() {
        if (Files.notExists(root, LinkOption.NOFOLLOW_LINKS)) {
            try {

                Files.createDirectory(root);
            } catch (IOException e) {
                throw new RuntimeException("Não foi possível inicializar a diretorio para upload! " + e);
            }
        }
    }

    private void salvaArquivoNoDiretorio(MultipartFile file) {
        if(Files.notExists(this.root.resolve(file.getOriginalFilename()))) {
            try {
                Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            } catch (Exception e) {
                throw new RuntimeException("Não foi possível armazenar o arquivo. Error: " + e.getMessage());
            }
        }
    }

    private File carregaArquivoDoDiretorio(String filename) {
        try {
            Path file = root.resolve(filename);
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

    private void deletaArquivoNoDiretorio() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

}
