package presenter.user.add;

import usecases.user.add.UserAddOutput;

import java.time.LocalDateTime;

public interface IUserAddPresenter {
    UserAddViewModel handle(UserAddOutput output, LocalDateTime now);
}
