package domain.user;

import domain.user.impl.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UserTest {
    @Test
    void givenNullName_thenUserThrowIllegalArgumentException() {
        var userId = mock(UserId.class);

        var exception = assertThrows(
            IllegalArgumentException.class,
            () -> new User(userId, null),
            "Expected constructor to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contentEquals("name is null"));
    }
}
