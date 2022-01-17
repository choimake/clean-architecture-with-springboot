package domain.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserNameTest {

    @Test
    void givenNullName_thenUserNameThrowIllegalArgumentException() {
        var exception = assertThrows(
            IllegalArgumentException.class,
            () -> new UserName(null),
            "Expected constructor to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contentEquals("name is null"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void givenBlankName_thenUserNameThrowIllegalArgumentException(String blankName) {
        var exception = assertThrows(
            IllegalArgumentException.class,
            () -> new UserName(blankName),
            "Expected constructor to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contentEquals("name is blank"));
    }

    @Test
    void givenTheSameNameToTheTwoUserNameObjects_thenTwoUserNameAreEqual() {
        var validName = "validName";
        var user = new UserName(validName);
        var otherUser = new UserName(validName);

        assertEquals(user, otherUser);
    }
}
