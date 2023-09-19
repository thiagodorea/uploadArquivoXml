package com.tdorea.agentes.controlles;

import com.tdorea.agentes.response.ConsolidadoPorRegiao;
import com.tdorea.agentes.services.RegiaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("regioes")
public class RegiaoController {

    @Autowired
    private RegiaoService regiaoService;
    @GetMapping("v1/consolidado/{sigla}/regiao")
    public ResponseEntity<List<ConsolidadoPorRegiao>> buscaDadosConsolidadoPorRegiao(@PathVariable String sigla) throws Exception {
        try{
            log.info("Buscando dados consolidados por regiao");
            return new ResponseEntity<>(regiaoService.buscaDadosConsolidadoPorRegiao(sigla), HttpStatus.OK);
        }
        catch (Exception e){
            log.error("Erro ao buscar dados consolidados por regiao", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
