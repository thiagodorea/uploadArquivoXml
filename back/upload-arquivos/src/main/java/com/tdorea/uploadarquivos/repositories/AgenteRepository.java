package com.tdorea.uploadarquivos.repositories;

import com.tdorea.uploadarquivos.entities.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, UUID> {
}
