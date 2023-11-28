package com.healthnove.schedulingHealthNove.domain.exception;

public class AgendamentoNaoEncontradoException extends RuntimeException {

    public AgendamentoNaoEncontradoException(){
        super("Consuta não agendada!");
    }
}
