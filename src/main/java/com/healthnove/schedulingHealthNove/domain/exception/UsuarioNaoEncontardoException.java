package com.healthnove.schedulingHealthNove.domain.exception;

public class UsuarioNaoEncontardoException extends RuntimeException {
    public UsuarioNaoEncontardoException(){
        super("Usuário não encontrado!");
    }
}
