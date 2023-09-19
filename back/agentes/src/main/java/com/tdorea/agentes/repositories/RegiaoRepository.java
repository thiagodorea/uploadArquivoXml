package com.tdorea.agentes.repositories;

import com.tdorea.agentes.entities.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, UUID> {

    @Query("SELECT r FROM Regiao r INNER JOIN r.geracao g INNER JOIN r.compra c INNER JOIN r.precoMedio p WHERE r.sigla = :siglaRegiao GROUP BY r" )
    List<Regiao> buscaDadosConsolidadoPorRegiao(String siglaRegiao);
}
