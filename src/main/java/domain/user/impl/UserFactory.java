package domain.user.impl;

import domain.user.IUser;
import domain.user.IUserFactory;
import domain.user.UserName;

public final class UserFactory implements IUserFactory {
    @Override
    public IUser create(String name) {
        var userName = new UserName(name);
        return new User(userName);
    }
}
