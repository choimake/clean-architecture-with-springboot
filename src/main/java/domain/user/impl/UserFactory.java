package domain.user.impl;

import domain.user.IUser;
import domain.user.IUserFactory;

public final class UserFactory implements IUserFactory {
    @Override
    public IUser create(String name) {
        return new User(name);
    }
}
