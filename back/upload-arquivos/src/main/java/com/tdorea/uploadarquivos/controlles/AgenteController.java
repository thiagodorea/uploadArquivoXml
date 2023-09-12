package com.tdorea.uploadarquivos.controlles;

import com.tdorea.uploadarquivos.dtos.AgenteDto;
import com.tdorea.uploadarquivos.services.AgenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@Slf4j
@RestController
@RequestMapping("agentes")
public class AgenteController {

    @Autowired
    private AgenteService agenteService;
    @GetMapping("v1/agente")
    public ResponseEntity<Page<AgenteDto>> buscaTodosAgentes(Pageable pageable) throws Exception {
        try{
            Page<AgenteDto> listaAgentes = agenteService.buscaTodosAgentes(pageable);
            log.info("Buscando agentes: total por pagina "+ listaAgentes.getSize() +": pagina " + listaAgentes.getPageable().getPageNumber() +" de "+ listaAgentes.getTotalPages());
            return new ResponseEntity<>(listaAgentes, HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error("Erro ao buscar agentes", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
