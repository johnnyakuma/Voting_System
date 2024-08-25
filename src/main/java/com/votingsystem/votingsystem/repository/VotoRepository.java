package com.votingsystem.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votingsystem.votingsystem.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
