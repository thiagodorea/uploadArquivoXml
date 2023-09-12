package com.tdorea.uploadarquivos.services;

import com.tdorea.uploadarquivos.dtos.AgenteDto;
import com.tdorea.uploadarquivos.entities.Agente;
import com.tdorea.uploadarquivos.repositories.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgenteService {

    @Autowired
    private AgenteRepository agenteRepository;

    @Transactional(readOnly = true)
    public Page<AgenteDto> buscaTodosAgentes(Pageable pageable) {
        return agenteRepository.findAll(pageable).map(x -> new AgenteDto(x));
    }

    @Transactional
    public AgenteDto salvaAgente(AgenteDto agenteDto) {
        return new AgenteDto(agenteRepository.save(new Agente(agenteDto)));
    }

}
