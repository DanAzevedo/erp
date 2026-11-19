package br.com.erp.administration.application.command;

import br.com.erp.administration.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BlockUserCommandTest {
    @Test
    public void shouldCreateCommandWithValidData(){
        // Arrange
        UUID userId = UUID.randomUUID();
        UUID actorId = UUID.randomUUID();
        String reason = "Motivo de teste";

        // Act
        BlockUserCommand blockUserCommand = new BlockUserCommand(userId, actorId, reason);

        // Assert
        assertEquals(userId, blockUserCommand.userId());
        assertEquals(actorId, blockUserCommand.actorId());
        assertEquals(reason, blockUserCommand.reason());
    }

    @Test
    public void shouldRejectNullUserId(){
        // Arrange
        UUID userId = null;
        UUID actorId = UUID.randomUUID();
        String reason = "Motivo de teste";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new BlockUserCommand(userId, actorId, reason));
    }

    @Test
    public void shouldRejectNullActorId(){
        // Arrange
        UUID userId = UUID.randomUUID();
        UUID actorId = null;
        String reason = "Motivo teste";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new BlockUserCommand(userId, actorId, reason));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    public void shouldRejectInvalidReason(String reason){
        // Arrange
        UUID userId = UUID.randomUUID();
        UUID actorId = UUID.randomUUID();

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new BlockUserCommand(userId, actorId, reason));
    }
}
