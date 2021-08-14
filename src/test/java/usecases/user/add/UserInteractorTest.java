package usecases.user.add;

import domain.user.impl.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import repositories.user.UserRepositoryInMemory;
import stubs.repositories.user.UserRepositoryAlwaysFailToSave;
import usecases.user.add.impl.UserAddInteractor;

import static org.junit.jupiter.api.Assertions.assertSame;

public final class UserInteractorTest {

    @Test
    void givenNullInput_thenUserAddOutputStatusIsInputIsNull() {
        var factory = new UserFactory();
        var repository = new UserRepositoryInMemory();
        var useCase = new UserAddInteractor(factory, repository);
        var output = useCase.create(null);
        assertSame(UserAddOutputStatus.INPUT_IS_NULL, output.status);
    }

    @Test
    void givenInput_NameParameterIsNull_thenUserAddOutputStatusIsUserNameIsInvalid() {
        var factory = new UserFactory();
        var repository = new UserRepositoryInMemory();
        var useCase = new UserAddInteractor(factory, repository);
        var input = new UserAddInput(null);
        var output = useCase.create(input);
        assertSame(UserAddOutputStatus.USER_NAME_IS_INVALID, output.status);
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " " })
    void givenInput_NameParameterIsInvalid_thenUserAddOutputStatusIsUserNameIsInvalid(String name) {
        var factory = new UserFactory();
        var repository = new UserRepositoryInMemory();
        var useCase = new UserAddInteractor(factory, repository);
        var input = new UserAddInput(name);
        var output = useCase.create(input);
        assertSame(UserAddOutputStatus.USER_NAME_IS_INVALID, output.status);
    }

    @Test
    void failToSaveUser_thenUserAddOutputStatusIsFailToSaveUser() {
        var factory = new UserFactory();
        var repository = new UserRepositoryAlwaysFailToSave();
        var useCase = new UserAddInteractor(factory, repository);
        var input = new UserAddInput("validName");
        var output = useCase.create(input);
        assertSame(UserAddOutputStatus.FAIL_TO_SAVE_USER, output.status);
    }

}
