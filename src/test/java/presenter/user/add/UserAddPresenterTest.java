package presenter.user.add;

import domain.user.impl.UserFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;
import presenter.user.add.impl.UserAddPresenter;
import usecases.user.add.UserAddOutput;
import usecases.user.add.UserAddOutputStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

// reference:
// https://qiita.com/opengl-8080/items/efe54204e25f615e322f
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserAddPresenterTest {

    private static final LocalDateTime datetime = LocalDateTime.of(2021, 7, 8, 22, 6, 0, 0);

    @BeforeAll
    public void setup() {
        // setup LocalDateTime mock
        MockedStatic<LocalDateTime> mock = Mockito.mockStatic(LocalDateTime.class, Mockito.CALLS_REAL_METHODS);
        mock.when(LocalDateTime::now).thenReturn(datetime);
    }

    @Test
    public void givenSuccessOutput_thenReturnSuccessViewModel() {
        var userName = "validName";
        var presenter = new UserAddPresenter();
        var output = new UserAddOutput(UserAddOutputStatus.SUCCESS, new UserFactory().create(userName));
        var viewModel = presenter.handle(output, LocalDateTime.now());

        assertEquals(userName, viewModel.userName());
        assertEquals("2021-07-08 22:06:00", viewModel.timestamp());
    }

    @Test
    public void givenNullOutput_thenThrowResponseStatusException() {
        var presenter = new UserAddPresenter();

        var exception = assertThrows(
            ResponseStatusException.class,
            () -> presenter.handle(null, LocalDateTime.now()),
            "Expected handle() to throw, but it didn't"
        );
        assertTrue(exception.getReason().contentEquals("output is null"));
    }
}
