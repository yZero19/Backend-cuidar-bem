package com.healthnove.schedulingHealthNove.domain.model;

import com.healthnove.schedulingHealthNove.domain.dto.AgendamentoRequestDto;
import com.healthnove.schedulingHealthNove.domain.dto.AgendamentoUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tb_agendamento")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paciente;
    private Date data;
    private String horario;
    private String medico;
    private String servico;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Agendamento(AgendamentoRequestDto request, Usuario usuario) {
        this.paciente = request.paciente();
        this.data = request.data();
        this.horario = request.horario();
        this.medico = request.medico();
        this.servico = request.servico();
        this.usuario = usuario;
    }

    public void atualizar(AgendamentoUpdateDto request) {
        this.paciente = request.paciente();
        this.data = request.data();
        this.horario = request.horario();
        this.medico = request.medico();
        this.servico = request.servico();
    }
}
