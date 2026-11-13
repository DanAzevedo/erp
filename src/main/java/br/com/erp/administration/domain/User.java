package br.com.erp.administration.domain;

import java.util.UUID;

public class User{
    private final UUID id;
    private String name;
    private String email;
    private UserStatus status;

    public User(String name, String email){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Até super-herói tem nome. Informe o seu.");
        }
        this.name = name;

        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Pombo-correio ainda não está integrado. Informe seu e-mail.");
        }
        this.email = email;

        this.status = UserStatus.PENDING;
        this.id = UUID.randomUUID();
    }

    public UUID getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public UserStatus getStatus(){
        return this.status;
    }

    public void activate(){
        if(this.status != UserStatus.PENDING){
            throw new IllegalStateException(
                    "O link de confirmação não é enfeite: confirme seu e-mail antes de ativar a conta."
            );
        }
        this.status = UserStatus.ACTIVE;
    }
}
