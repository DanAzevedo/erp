package br.com.erp.administration.domain;

import java.util.UUID;

public class User{
    private final UUID id;
    private String name;
    private String email;
    private UserStatus status;


    private User(UUID id, String name, String email, UserStatus status){
        if(id == null){
            throw new IllegalArgumentException("Houve um problema com seu ID. Favor contatar o suporte.");
        }
        this.id = id;

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Até super-herói tem nome. Informe o seu.");
        }
        this.name = name;

        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Pombo-correio ainda não está integrado. Informe seu e-mail.");
        }
        this.email = email;

        if(status == null){
            throw new IllegalArgumentException("Há algo de errado com o estado da conta. Favor contatar o suporte.");
        }
        this.status = status;
    }

    public User(String name, String email){
        this(UUID.randomUUID(), name, email, UserStatus.PENDING);
    }

    public void activate(){
        if(this.status != UserStatus.PENDING){
            throw new IllegalStateException("O link de confirmação não é enfeite: confirme seu e-mail antes de ativar a conta.");
        }
        this.status = UserStatus.ACTIVE;
    }

    public static User reconstitute(UUID id, String name, String email, UserStatus status){
        return new User(id, name, email, status);
    }

    public void block(){
        if(this.status == UserStatus.BLOCKED){
            throw new IllegalStateException("Usuário já se encontra em estado de bloqueio.");
        }
        this.status = UserStatus.BLOCKED;
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
}
