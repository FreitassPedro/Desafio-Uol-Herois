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
    private GrupoService grupoService;
    public Jogador salvar(JogadorDto dto) {
        var jogador = new Jogador(dto);

        var codinome = grupoService.getCodinome(dto.grupo());

        jogador.setCodinome(codinome);
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> buscarTodos() {
        return jogadorRepository.findAll();
    }
 }
