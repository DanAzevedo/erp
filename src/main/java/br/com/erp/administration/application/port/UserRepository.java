package br.com.erp.administration.application.port;

import br.com.erp.administration.domain.User;

import java.util.Optional;
import java.util.UUID;


public interface UserRepository{
    Optional<User> findById(UUID id);
    void save(User user);
}
