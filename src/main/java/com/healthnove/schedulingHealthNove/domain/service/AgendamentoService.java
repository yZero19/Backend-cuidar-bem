package com.healthnove.schedulingHealthNove.domain.service;

import com.healthnove.schedulingHealthNove.domain.dto.AgendamentoRequestDto;
import com.healthnove.schedulingHealthNove.domain.dto.AgendamentoUpdateDto;
import com.healthnove.schedulingHealthNove.domain.exception.AgendamentoNaoEncontradoException;
import com.healthnove.schedulingHealthNove.domain.model.Agendamento;
import com.healthnove.schedulingHealthNove.domain.model.Usuario;
import com.healthnove.schedulingHealthNove.domain.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    public List<Agendamento> buscarPorIdDeUsuario(Long id) {
        Usuario usuario = usuarioService.findById(id);
        return repository.findByUsuario(usuario);
    }

    public Agendamento criar(Long id, AgendamentoRequestDto request) {
        return repository.save(new Agendamento(request, usuarioService.findById(id)));
    }

    @Transactional
    public Agendamento atualizar(AgendamentoUpdateDto request) {
        Agendamento agendamento = findById(request.id());
        agendamento.atualizar(request);
        return agendamento;
    }

    @Transactional
    public void apagar(Long id) {
        Agendamento agendamento = this.findById(id);
        repository.delete(agendamento);
    }

    private Agendamento findById(Long id) {
        return repository.findById(id).orElseThrow(AgendamentoNaoEncontradoException::new);
    }

}
