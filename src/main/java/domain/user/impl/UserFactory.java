package domain.user.impl;

import domain.user.IUser;
import domain.user.IUserFactory;
import domain.user.UserId;
import domain.user.UserName;

public final class UserFactory implements IUserFactory {

    @Override
    public IUser create(int id, String name) {
        var userId = new UserId(id);
        var userName = new UserName(name);
        return new User(userId, userName);
    }

    @Override
    public IUser create(String name) {
        var userName = new UserName(name);
        return new User(null, userName);
    }
}
