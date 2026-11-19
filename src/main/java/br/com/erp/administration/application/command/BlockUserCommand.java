package br.com.erp.administration.application.command;

import java.util.UUID;

public record BlockUserCommand(
        UUID userId,
        UUID actorId,
        String reason
){
    public BlockUserCommand{
        if(userId == null){
            throw new IllegalArgumentException("Informe o usuário a ser bloqueado");
        }
        if(actorId == null){
            throw new IllegalArgumentException("Informe o responsável pelo bloqueio.");
        }
        if(reason == null || reason.isBlank()){
            throw new IllegalArgumentException("Deve haver uma justificativa para o bloqueio.");
        }
    }
}
