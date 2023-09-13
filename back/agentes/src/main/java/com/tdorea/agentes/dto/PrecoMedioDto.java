package com.tdorea.agentes.dto;

import com.tdorea.agentes.entities.PrecoMedio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PrecoMedioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private ArrayList<Double> valor;

    public PrecoMedioDto(PrecoMedio precoMedio) {
        this.id = precoMedio.getId();
        this.valor = null;
    }
}
