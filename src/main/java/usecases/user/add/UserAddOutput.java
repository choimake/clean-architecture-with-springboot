package usecases.user.add;

import domain.user.IUser;

public record UserAddOutput(UserAddOutputStatus status, IUser user) {
}

