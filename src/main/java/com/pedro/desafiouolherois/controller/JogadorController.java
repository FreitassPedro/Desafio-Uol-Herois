package com.pedro.desafiouolherois.controller;


import com.pedro.desafiouolherois.entity.dto.JogadorDto;
import com.pedro.desafiouolherois.service.JogadorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class JogadorController {

    private JogadorService jogadorService;

    @PostMapping("/salvarJogador")
    public String salvar(JogadorDto dto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "jogador-form";
        }

        jogadorService.salvar(dto);
        return "redirect:/";
    }

   @GetMapping("/jogadorForm")
    public String mostrarJogadorForm(JogadorDto dto) {
        return "jogador-form";
    }
}
