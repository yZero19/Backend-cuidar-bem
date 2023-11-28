package com.healthnove.schedulingHealthNove.domain.dto;

import com.healthnove.schedulingHealthNove.domain.enumerated.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDto(
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        @NotNull
        Integer idade,
        @NotNull
        Sexo sexo,
        @NotBlank
        String cpf,
        @NotBlank
        String rg,
        @NotBlank
        String telefone,
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
