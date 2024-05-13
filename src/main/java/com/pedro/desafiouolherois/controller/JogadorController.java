package com.pedro.desafiouolherois.controller;


import com.pedro.desafiouolherois.entity.dto.JogadorDto;
import com.pedro.desafiouolherois.service.JogadorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class JogadorController {
    private JogadorService jogadorService;

    @PostMapping("/salvarJogador")
    public String salvar(JogadorDto dto) {
        jogadorService.salvar(dto);
        return "redirect/jogador/listar";
    }
}
