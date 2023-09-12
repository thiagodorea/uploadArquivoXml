package com.tdorea.agentes.dto;

import com.tdorea.agentes.entities.Agente;
import com.tdorea.agentes.entities.Agentes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AgentesDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

    private List<Agente> agente;

    public AgentesDto(Agentes agentes) {
        this.id = agentes.getId();
        this.agente = agentes.getAgente();
    }
}
