package com.healthnove.schedulingHealthNove.domain.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public record AgendamentoRequestDto(
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
