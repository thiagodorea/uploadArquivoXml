package com.tdorea.uploadarquivos.dtos;

import com.tdorea.uploadarquivos.entities.Regiao;
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
public class RegiaoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

    private String sigla;

    private GeracaoDto geracao;

    private CompraDto compra;

    private PrecoMedioDto precoMedio;


    public RegiaoDto(Regiao regiao) {
        this.id = regiao.getId();
        this.sigla = regiao.getSigla();
        this.geracao = new GeracaoDto(regiao.getGeracao());
        this.compra = new CompraDto(regiao.getCompra());
        this.precoMedio = new PrecoMedioDto(regiao.getPrecoMedio());
    }
}
