package br.com.erp.administration.domain;

import org.junit.jupiter.api.Test;

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
        User user = new User("Danel", "daniel@test.com");

        // Act
        user.activate();

        // Assert
        assertEquals(UserStatus.ACTIVE, user.getStatus());

    }

    @Test
    public void shouldRejectActivationOfAlreadyActiveUser(){
        // Arrange
        User user = new User("Danel", "daniel@test.com");
        user.activate();

        // Act + Assert
        assertThrows(IllegalStateException.class, () -> user.activate());
        assertEquals(UserStatus.ACTIVE, user.getStatus());
    }
}
