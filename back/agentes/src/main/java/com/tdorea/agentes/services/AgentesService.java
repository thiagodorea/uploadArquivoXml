package com.tdorea.agentes.services;

import com.tdorea.agentes.dto.AgentesDto;
import com.tdorea.agentes.entities.Agentes;
import com.tdorea.agentes.repositories.AgentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentesService {

    @Autowired
    private AgentesRepository agentesRepository;

    @Transactional(readOnly = true)
    public List<AgentesDto> buscaTodosAgentes() {
        return agentesRepository.findAll().stream().map(AgentesDto::new).collect(Collectors.toList());
    }

    @Transactional
    public AgentesDto salvaAgentes(AgentesDto agentesDto) {
        return new AgentesDto(agentesRepository.save(new Agentes(agentesDto)));
    }
}
