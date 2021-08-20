package usecases.user.add;

import domain.user.impl.User;
import domain.user.impl.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import repositories.user.UserRepositoryInMemory;
import stubs.repositories.user.UserRepositoryAlwaysFailToSave;
import usecases.user.add.impl.UserAddInteractor;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public final class UserInteractorTest {

    @Test
    void givenNullInput_thenUserAddOutputStatusIsInputIsNull() {
        // mock
        var factory = mock(UserFactory.class);
        var repository = mock(UserRepositoryInMemory.class);

        var useCase = new UserAddInteractor(factory, repository);
        var output = useCase.create(null);
        assertSame(UserAddOutputStatus.INPUT_IS_NULL, output.status());
    }

    @Test
    void givenInput_NameParameterIsNull_thenUserAddOutputStatusIsUserNameIsInvalid() {
        // mock
        var factory = mock(UserFactory.class);
        when(factory.create(null)).thenThrow(IllegalArgumentException.class);
        var repository = mock(UserRepositoryInMemory.class);

        var useCase = new UserAddInteractor(factory, repository);
        var input = new UserAddInput(null);
        var output = useCase.create(input);
        assertSame(UserAddOutputStatus.USER_NAME_IS_INVALID, output.status());
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " " })
    void givenInput_NameParameterIsInvalid_thenUserAddOutputStatusIsUserNameIsInvalid(String name) {
        // mock
        var factory = mock(UserFactory.class);
        when(factory.create(name)).thenThrow(IllegalArgumentException.class);
        var repository = mock(UserRepositoryInMemory.class);

        var useCase = new UserAddInteractor(factory, repository);
        var input = new UserAddInput(name);
        var output = useCase.create(input);
        assertSame(UserAddOutputStatus.USER_NAME_IS_INVALID, output.status());
    }

    @Test
    void failToSaveUser_thenUserAddOutputStatusIsFailToSaveUser() throws IOException {
        // mock
        var validName = "name";
        var user = mock(User.class);
        var factory = mock(UserFactory.class);
        when(factory.create(validName)).thenReturn(user);
        var repository = mock(UserRepositoryInMemory.class);
        doThrow(IOException.class).when(repository).save(user);

        var useCase = new UserAddInteractor(factory, repository);
        var input = new UserAddInput(validName);
        var output = useCase.create(input);
        assertSame(UserAddOutputStatus.FAIL_TO_SAVE_USER, output.status());
    }

}
