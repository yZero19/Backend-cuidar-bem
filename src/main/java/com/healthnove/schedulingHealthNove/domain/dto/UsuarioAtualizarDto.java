package com.healthnove.schedulingHealthNove.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioAtualizarDto(
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        @NotBlank
        String telefone,
        @NotBlank
        String senha
) {
}
