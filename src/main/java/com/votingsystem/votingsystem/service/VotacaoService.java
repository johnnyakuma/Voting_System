package com.votingsystem.votingsystem.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingsystem.votingsystem.model.Candidato;
import com.votingsystem.votingsystem.model.Voto;
import com.votingsystem.votingsystem.repository.CandidatoRepository;
import com.votingsystem.votingsystem.repository.VotoRepository;

@Service
public class VotacaoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private VotoRepository votoRepository;

    public List<Candidato> listarCandidatos() {
        return candidatoRepository.findAll();
    }

    public void registrarVoto(Long candidatoId) {
        Candidato candidato = candidatoRepository.findById(candidatoId).orElseThrow(() -> new RuntimeException("Candidato não encontrado"));
        Voto voto = new Voto();
        voto.setCandidato(candidato);
        votoRepository.save(voto);
    }

    public Map<Candidato, Long> contarVotosPorCandidato() {
        return votoRepository.findAll().stream()
            .collect(Collectors.groupingBy(Voto::getCandidato, Collectors.counting()));
    }
    
    public long contarTotalVotos() {
        return votoRepository.count();
    }
    
}
