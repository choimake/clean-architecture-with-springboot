package presenter.user.add.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import presenter.user.add.IUserAddPresenter;
import presenter.user.add.UserAddViewModel;
import usecases.user.add.UserAddOutput;
import usecases.user.add.UserAddOutputStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserAddPresenter implements IUserAddPresenter {

    @Override
    public UserAddViewModel handle(UserAddOutput output, LocalDateTime now) {
        if (output == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "output is null");
        }

        if (output.status() == UserAddOutputStatus.INPUT_IS_NULL) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "userAddInput is null");
        }

        if (output.status() == UserAddOutputStatus.USER_NAME_IS_INVALID) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user name is invalid");
        }

        if (output.status() == UserAddOutputStatus.FAIL_TO_SAVE_USER) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "save user failed");
        }

        var formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
        var timestamp = now.format(formatter);
        return new UserAddViewModel(output.user().getName().getValue(), timestamp);
    }
}
