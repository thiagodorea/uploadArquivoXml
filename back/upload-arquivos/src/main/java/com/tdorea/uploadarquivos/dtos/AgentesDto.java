package com.tdorea.uploadarquivos.dtos;

import com.tdorea.uploadarquivos.entities.Agente;
import com.tdorea.uploadarquivos.entities.Agentes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
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

    private Agente agente;

    public AgentesDto(Agentes agentes) {
        this.id = agentes.getId();
        this.agente = agentes.getAgente();
    }
}


