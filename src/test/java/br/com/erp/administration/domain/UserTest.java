package br.com.erp.administration.domain;

import org.apache.tomcat.util.buf.UEncoder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.channels.IllegalChannelGroupException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest{
    @Test
    public void shouldCreateUserWithPendingStatus(){
        // Arrange
        String name = "Daniel";
        String email = "daniel@test.com";

        // Act
        User user = new User(name, email);

        // Assert
        assertEquals(UserStatus.PENDING, user.getStatus());
    }

    @Test
    public void shouldRejectUserWithBlankName(){
        //Arrange
        String name = "    ";
        String email = "daniel@test.com";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, email));
    }

    @Test
    public void shouldRejectUserWithBlankEmail(){
        // Arrange
        String name = "Daniel";
        String email = "      ";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, email));
    }

    @Test
    public void shouldRejectedUserWithNullName(){
        // Arange
        String name = null;
        String email = "daniel@test.com";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, email));
    }

    @Test
    public void shouldRejectedUserWithNullEmail(){
        // Arrange
        String name = "Daniel";
        String email = null;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, email));
    }

    @Test
    public void shouldGenerateUserId(){
        // Arrange
        String name = "Daniel";
        String email = "daniel@test.com";

        // Act
        User user = new User(name, email);

        // Assert
        assertNotNull(user.getId());
    }

    @Test
    public void shouldGenerateDifferentIdsForUsers(){
        // Arrange
        String name = "Daniel";
        String email = "daniel@test.com";

        // Act
        User firstUser = new User(name, email);
        User secondUser = new User(name, email);

        // Assert
        assertNotEquals(firstUser.getId(), secondUser.getId());
    }

    @Test
    public void shouldActivatePendingUser(){
        // Arrange
        User user = new User("Daniel", "daniel@test.com");

        // Act
        user.activate();

        // Assert
        assertEquals(UserStatus.ACTIVE, user.getStatus());

    }

    @Test
    public void shouldRejectActivationOfAlreadyActiveUser(){
        // Arrange
        User user = new User("Daniel", "daniel@test.com");
        user.activate();

        // Act + Assert
        assertThrows(IllegalStateException.class, user::activate);
        assertEquals(UserStatus.ACTIVE, user.getStatus());
    }

    @Test
    public void shouldReconstituteUserPreservingData(){
        // Arrange
        UUID id = UUID.randomUUID();
        String name = "Daniel";
        String email = "daniel@test.com";
        UserStatus status = UserStatus.BLOCKED;

        // Act
        User user = User.reconstitute(id, name, email, status);

        // Assert
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(status, user.getStatus());
    }

    @Test
    public void shouldRejectActivationOfBlockedUser(){
        // Arrange
        UUID id = UUID.randomUUID();
        String name = "Daniel";
        String email = "daniel@test.com";
        UserStatus status = UserStatus.BLOCKED;
        User user = User.reconstitute(id, name, email, status);

        // Act + Assert
        assertThrows(IllegalStateException.class, user::activate);
        assertEquals(UserStatus.BLOCKED, user.getStatus());
    }

    @Test
    public void shouldRejectActivationOfInactiveUser(){
        // Arrange
        UUID id = UUID.randomUUID();
        String name = "Daniel";
        String email = "daniel@test.com";
        UserStatus status = UserStatus.INACTIVE;
        User user = User.reconstitute(id, name, email, status);

        // Act + Assert
        assertThrows(IllegalStateException.class, user::activate);
        assertEquals(UserStatus.INACTIVE, user.getStatus());
    }

    @Test
    public void shouldRejectReconstitutionWithNullId(){
        // Arrange
        UUID id = null;
        String name = "Daniel";
        String email = "daniel@test.com";
        UserStatus status = UserStatus.ACTIVE;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> User.reconstitute(id, name, email, status));
    }

    @Test
    public void shouldRejectReconstitutionWithNullStatus(){
        // Arrange
        UUID id = UUID.randomUUID();
        String name = "Daniel";
        String email = "daniel@test.com";
        UserStatus status = null;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> User.reconstitute(id, name, email, status));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    public void shouldRejectReconstitutionWithInvalidName(String name){
        // Arrange
        UUID id = UUID.randomUUID();
        String email = "daniel@test.com";
        UserStatus status = UserStatus.ACTIVE;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> User.reconstitute(id, name, email, status));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    public void shouldRejectReconstitutionWithInvalidEmail(String email){
        // Arrange
        UUID id = UUID.randomUUID();
        String name = "Daniel";
        UserStatus status = UserStatus.ACTIVE;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> User.reconstitute(id, name, email, status));
    }

    @Test
    public void shouldBlockActiveUser(){
        // Arrange
        UUID id = UUID.randomUUID();
        String name = "Daniel";
        String email = "daniel@test.com";
        UserStatus status = UserStatus.ACTIVE;
        User user = User.reconstitute(id, name, email, status);

        // Act
        user.block();

        // Assert
        assertEquals(UserStatus.BLOCKED, user.getStatus());
    }

    @Test
    public void shouldRejectBlockingAlreadyBlockedUser(){
        // Arrange
        UUID id = UUID.randomUUID();
        String name = "Daniel";
        String email = "daniel@test.com";
        UserStatus status = UserStatus.BLOCKED;
        User user = User.reconstitute(id, name, email, status);

        // Act + Assert
        assertThrows(IllegalStateException.class, user::block);
        assertEquals(UserStatus.BLOCKED, user.getStatus());
    }

    @Test
    public void shouldBlockPendingUser(){
        // Arrange
        String name = "Daniel";
        String email = "daniel@test.com";
        User user = new User(name, email);

        // Act
        user.block();

        // Assert
        assertEquals(UserStatus.BLOCKED, user.getStatus());
    }

    @Test
    public void shouldBlockInactiveUser(){
        // Arange
        UUID id = UUID.randomUUID();
        String name = "Daniel";
        String email = "daniel@test.com";
        UserStatus status = UserStatus.INACTIVE;
        User user = User.reconstitute(id, name, email, status);

        // Act
        user.block();

        // Assert
        assertEquals(UserStatus.BLOCKED, user.getStatus());
    }

    @Test
    public void shouldRejectActivationAfterBlockingPendingUser(){
        // Arrange
        String name = "Daniel";
        String email = "daniel@test.com";
        User user = new User(name,  email);
        user.block();

        // Act + Assert
        assertThrows(IllegalStateException.class, user::activate);
        assertEquals(UserStatus.BLOCKED, user.getStatus());
    }
}
