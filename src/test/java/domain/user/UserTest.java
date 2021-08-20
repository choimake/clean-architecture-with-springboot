package domain.user;

import domain.user.impl.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    void givenNullName_thenUserThrowIllegalArgumentException() {
        var validUserId = new UserId(1);
        var exception = assertThrows(
            IllegalArgumentException.class,
            () -> new User(validUserId, null),
            "Expected constructor to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contentEquals("name is null"));
    }
}
