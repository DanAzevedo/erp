package br.com.erp.administration.application.usecase;

import br.com.erp.administration.application.port.UserRepository;

public class BlockUser{
    private final UserRepository userRepository;

    public BlockUser(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
