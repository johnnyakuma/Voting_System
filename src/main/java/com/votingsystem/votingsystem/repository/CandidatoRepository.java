package com.votingsystem.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votingsystem.votingsystem.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
