package domain.user;

import domain.user.impl.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class UserFactoryTest {

    @Test
    void givenNullName_thenThrowIllegalArgumentException() {
        var factory = new UserFactory();
        var exception = assertThrows(
            IllegalArgumentException.class,
            () -> factory.create(null),
            "Expected create() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contentEquals("name is null"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " " })
    void givenEmptyNameOrOnlyWhitespaceName_thenThrowIllegalArgumentException(String name) {
        var factory = new UserFactory();
        var exception = assertThrows(
            IllegalArgumentException.class,
            () -> factory.create(name),
            "Expected create() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contentEquals("name is empty or only whitespace"));
    }
}
