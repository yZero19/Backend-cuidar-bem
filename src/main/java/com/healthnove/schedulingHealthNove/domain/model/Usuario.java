package com.healthnove.schedulingHealthNove.domain.model;

import com.healthnove.schedulingHealthNove.domain.dto.UsuarioAtualizarDto;
import com.healthnove.schedulingHealthNove.domain.dto.UsuarioRequestDto;
import com.healthnove.schedulingHealthNove.domain.enumerated.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private Sexo sexo;
    @JoinColumn(unique = true)
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private String senha;

    public Usuario(UsuarioRequestDto request) {
        this.nome = request.nome();
        this.sobrenome = request.sobrenome();
        this.idade = request.idade();
        this.sexo = request.sexo();
        this.cpf = request.cpf();
        this.rg = request.rg();
        this.telefone = request.telefone();
        this.email = request.email();
        this.senha = request.senha();
    }

    public void atualizar(UsuarioAtualizarDto request) {
        this.nome = request.nome();
        this.sobrenome = request.sobrenome();
        this.telefone = request.telefone();
        this.senha = request.senha();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
