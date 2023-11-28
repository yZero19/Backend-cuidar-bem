package com.healthnove.schedulingHealthNove.domain.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AgendamentoUpdateDto(
        @NotNull
        Long id,
        @NotBlank
        String paciente,
        @FutureOrPresent
        Date data,
        @NotBlank
        String horario,
        @NotBlank
        String medico,
        @NotBlank
        String servico
) {
}
