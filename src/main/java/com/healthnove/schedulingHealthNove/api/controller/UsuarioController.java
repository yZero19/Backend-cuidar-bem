package com.healthnove.schedulingHealthNove.api.controller;

import com.healthnove.schedulingHealthNove.domain.dto.UsuarioAtualizarDto;
import com.healthnove.schedulingHealthNove.domain.dto.UsuarioRequestDto;
import com.healthnove.schedulingHealthNove.domain.model.Usuario;
import com.healthnove.schedulingHealthNove.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody @Valid UsuarioRequestDto request, UriComponentsBuilder uriBuilder) {
        Usuario usuario = service.criar(request);
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioAtualizarDto request) {
        return ResponseEntity.ok().body(service.atualizar(id, request));
    }

}
