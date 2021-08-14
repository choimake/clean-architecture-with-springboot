package domain.user;

import domain.user.impl.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;

public final class UserFactoryTest {

    @Test
    void givenNullName_thenIsValidNameReturnFalse() {
        var factory = new UserFactory();
        var user = factory.create(null);
        assertFalse(user.isValidName());
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " " })
    void givenEmptyNameOrOnlyWhitespaceName_thenIsValidNameReturnFalse(String name) {
        var factory = new UserFactory();
        var user = factory.create(name);
        assertFalse(user.isValidName());
    }
}
