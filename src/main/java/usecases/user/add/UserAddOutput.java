package usecases.user.add;

import domain.user.IUser;

public final class UserAddOutput {

    public final UserAddOutputStatus status;
    public final IUser user;

    public UserAddOutput(UserAddOutputStatus status, IUser user) {
        this.status = status;
        this.user = user;
    }
}

