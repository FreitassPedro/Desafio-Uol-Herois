package com.pedro.desafiouolherois.entity.dto;

import com.pedro.desafiouolherois.entity.Grupo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JogadorDto(
        @NotBlank(message = "Nome obrigatório")
        String nome,

        @NotBlank(message = "Email obrigatório")
        String email,
        String telefone,

        @NotNull(message = "Grupo obrigatório")
        Grupo grupo
) {

}
