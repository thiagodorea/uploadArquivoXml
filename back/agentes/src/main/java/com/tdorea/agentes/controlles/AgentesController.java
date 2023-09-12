package com.tdorea.agentes.controlles;

import com.tdorea.agentes.dto.AgenteDto;
import com.tdorea.agentes.dto.AgentesDto;
import com.tdorea.agentes.services.AgenteService;
import com.tdorea.agentes.services.AgentesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("agentes")
public class AgentesController {

    @Autowired
    private AgentesService agentesService;
    @GetMapping("v1/agente")
    public ResponseEntity<List<AgentesDto>> buscaTodosAgentes() throws Exception {
        try{
            log.info("Buscando agentes");
            return new ResponseEntity<>(agentesService.buscaTodosAgentes(), HttpStatus.OK);
        }
        catch (Exception e){
            log.error("Erro ao buscar agentes", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
