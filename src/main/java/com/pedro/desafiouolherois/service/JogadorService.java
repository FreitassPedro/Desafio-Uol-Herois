package com.pedro.desafiouolherois.service;

import com.pedro.desafiouolherois.entity.Jogador;
import com.pedro.desafiouolherois.entity.dto.JogadorDto;
import com.pedro.desafiouolherois.repository.JogadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JogadorService {

    private JogadorRepository jogadorRepository;

    public Jogador salvar(JogadorDto dto) {
        var jogador = new Jogador(dto);

        jogador.setCodinome("XXXXXXX");
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> buscarTodos() {
        return jogadorRepository.findAll();
    }
 }
