package br.com.erp.administration.application.usecase;

import br.com.erp.administration.application.command.BlockUserCommand;
import br.com.erp.administration.application.exception.UserNotFoundException;
import br.com.erp.administration.application.port.UserRepository;
import br.com.erp.administration.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cglib.core.Block;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlockUserTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private BlockUser blockUser;

    @Test
    public void shouldRejectBlockingNonExistentUser(){
        // Arrange
        UUID userId = UUID.randomUUID();
        UUID actorId = UUID.randomUUID();
        String reason = "Motivo de teste";
        BlockUserCommand blockUserCommand = new BlockUserCommand(userId, actorId, reason);
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(UserNotFoundException.class, () -> blockUser.execute(blockUserCommand));
        verify(userRepository).findById(userId);
        verify(userRepository, never()).save(any());
    }
}
