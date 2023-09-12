package com.tdorea.uploadarquivos.services;

import com.tdorea.uploadarquivos.dtos.AgentesDto;
import com.tdorea.uploadarquivos.entities.Agentes;
import com.tdorea.uploadarquivos.repositories.AgentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgentesService {

    @Autowired
    private AgentesRepository agentesRepository;

    @Transactional(readOnly = true)
    public Page<AgentesDto> buscaTodosAgentes(Pageable pageable) {
        return agentesRepository.findAll(pageable).map(x -> new AgentesDto(x));
    }

    @Transactional
    public AgentesDto salvaAgentes(AgentesDto agentesDto) {
        return new AgentesDto(agentesRepository.save(new Agentes(agentesDto)));
    }
}
