package com.votingsystem.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.votingsystem.votingsystem.service.VotacaoService;

@Controller
public class VotacaoController {

    @Autowired
    private VotacaoService votacaoService;

    @GetMapping("/")
    public String mostrarVotacao(Model model) {
        model.addAttribute("candidatos", votacaoService.listarCandidatos());
        model.addAttribute("votosPorCandidato", votacaoService.contarVotosPorCandidato());
        model.addAttribute("totalVotos", votacaoService.contarTotalVotos()); // Adiciona o total de votos ao modelo
        return "votacao";	
    }

    @PostMapping("/votar")
    public String votar(@RequestParam Long candidatoId) {
        votacaoService.registrarVoto(candidatoId);
        return "redirect:/";
    }
}
