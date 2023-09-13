package com.tdorea.agentes.dto;

import com.tdorea.agentes.entities.Compra;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CompraDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private ArrayList<Double> valor;

    public CompraDto(Compra compra) {
        this.id = compra.getId();
        this.valor = compra.getValor();
    }
}
