package com.tdorea.uploadarquivos.repositories;

import com.tdorea.uploadarquivos.entities.Agentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgentesRepository extends JpaRepository<Agentes, UUID> {
}
