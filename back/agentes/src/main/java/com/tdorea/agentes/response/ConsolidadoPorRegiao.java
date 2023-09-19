package com.tdorea.agentes.response;

import com.tdorea.agentes.dto.CompraDto;
import com.tdorea.agentes.dto.GeracaoDto;
import com.tdorea.agentes.dto.PrecoMedioDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ConsolidadoPorRegiao implements Serializable {

    private static final long serialVersionUID = 1L;

    private String regiao;

    private DadosPorRegiao dadosPorRegiao;

}
