package br.com.erp.administration.application.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UUID userId){
        super("Usuário pertencente ao ID " + userId + " não foi encontrado.");
    }
}
