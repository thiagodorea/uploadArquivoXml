package com.tdorea.uploadarquivos.dtos;

import com.tdorea.uploadarquivos.entities.Geracao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GeracaoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

    private ArrayList<Double> valor;

    public GeracaoDto(Geracao geracao) {
        this.id = geracao.getId();
        this.valor = geracao.getValor();
    }

}