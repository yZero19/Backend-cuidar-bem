package com.healthnove.schedulingHealthNove.api.controller;

import com.healthnove.schedulingHealthNove.domain.dto.AgendamentoRequestDto;
import com.healthnove.schedulingHealthNove.domain.dto.AgendamentoUpdateDto;
import com.healthnove.schedulingHealthNove.domain.dto.UsuarioRequestDto;
import com.healthnove.schedulingHealthNove.domain.model.Agendamento;
import com.healthnove.schedulingHealthNove.domain.model.Usuario;
import com.healthnove.schedulingHealthNove.domain.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<List<Agendamento>> buscarPorIdDeUsuario(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarPorIdDeUsuario(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Agendamento> criar(@PathVariable Long id, @RequestBody @Valid AgendamentoRequestDto request, UriComponentsBuilder uriBuilder) {
        Agendamento agendamento = service.criar(id, request);
        URI uri = uriBuilder.path("/agendamentos/{id}").buildAndExpand(agendamento.getId()).toUri();
        return ResponseEntity.created(uri).body(agendamento);
    }

    @PutMapping
    public ResponseEntity<Agendamento> atualizar(@RequestBody @Valid AgendamentoUpdateDto request){
        return ResponseEntity.ok().body(service.atualizar(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar (@PathVariable Long id){
        service.apagar(id);
        return ResponseEntity.noContent().build();
    }



}
