package com.healthnove.schedulingHealthNove.domain.repository;

import com.healthnove.schedulingHealthNove.domain.model.Agendamento;
import com.healthnove.schedulingHealthNove.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
    List<Agendamento> findByUsuario(Usuario usuario);
}
