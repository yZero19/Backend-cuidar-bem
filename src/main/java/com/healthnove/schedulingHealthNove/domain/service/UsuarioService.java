package com.healthnove.schedulingHealthNove.domain.service;

import com.healthnove.schedulingHealthNove.domain.dto.UsuarioAtualizarDto;
import com.healthnove.schedulingHealthNove.domain.dto.UsuarioRequestDto;
import com.healthnove.schedulingHealthNove.domain.exception.UsuarioNaoEncontardoException;
import com.healthnove.schedulingHealthNove.domain.model.Usuario;
import com.healthnove.schedulingHealthNove.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario criar(UsuarioRequestDto request) {
        Usuario usuario = new Usuario(request);
        usuario.setSenha(encryptPassword(request.senha()));
        return repository.save(usuario);
    }

    public Usuario buscar(Long id) {
        return this.findById(id);
    }

    @Transactional
    public Usuario atualizar(Long id, UsuarioAtualizarDto request) {
        Usuario usuario = this.findById(id);
        usuario.atualizar(request);
        return usuario;
    }

    public Usuario findById(Long id) {
        return repository.findById(id).orElseThrow(UsuarioNaoEncontardoException::new);
    }

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
