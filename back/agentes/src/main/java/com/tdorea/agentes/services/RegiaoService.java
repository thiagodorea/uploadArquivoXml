package com.tdorea.agentes.services;

import com.tdorea.agentes.dto.CompraDto;
import com.tdorea.agentes.dto.GeracaoDto;
import com.tdorea.agentes.dto.PrecoMedioDto;
import com.tdorea.agentes.dto.RegiaoDto;
import com.tdorea.agentes.entities.Compra;
import com.tdorea.agentes.entities.Regiao;
import com.tdorea.agentes.repositories.RegiaoRepository;
import com.tdorea.agentes.response.ConsolidadoPorRegiao;
import com.tdorea.agentes.response.DadosPorRegiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Transactional(readOnly = true)
    public List<ConsolidadoPorRegiao> buscaDadosConsolidadoPorRegiao(String sigla) {
        return regiaoRepository.buscaDadosConsolidadoPorRegiao(sigla).stream().map(regiao -> toMapConsolidadoPorRegiao(regiao)).collect(Collectors.toList());
    }
    private ConsolidadoPorRegiao toMapConsolidadoPorRegiao(Regiao regiao) {
        return ConsolidadoPorRegiao.builder()
                .regiao(regiao.getSigla())
                .dadosPorRegiao(
                        DadosPorRegiao.builder()
                                .geracao( new GeracaoDto(regiao.getGeracao()))
                                .compra( new CompraDto(regiao.getCompra()))
                                .precoMedio( new PrecoMedioDto(regiao.getPrecoMedio())).build()
                ).build();
    }

}
