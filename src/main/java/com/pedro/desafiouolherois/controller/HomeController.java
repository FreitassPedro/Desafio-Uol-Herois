package com.pedro.desafiouolherois.controller;

import com.pedro.desafiouolherois.service.JogadorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    private JogadorService jogadorService;

    @GetMapping
    public ModelAndView jogadores() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("jogador-lista.html");
        final var jogadores = jogadorService.buscarTodos();

        modelAndView.getModel().put("jogadores", jogadores.isEmpty() ? null : jogadores);

        return modelAndView;
    }

}
