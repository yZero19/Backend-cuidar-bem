package com.healthnove.schedulingHealthNove.domain.repository;

import com.healthnove.schedulingHealthNove.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String cpf);
}
