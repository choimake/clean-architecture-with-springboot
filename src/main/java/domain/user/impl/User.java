package domain.user.impl;

import domain.user.IUser;
import domain.user.UserName;

public final class User implements IUser {
    private final UserName name;

    public User(UserName name) {
        this.name = name;
    }

    @Override
    public UserName getName() {
        return this.name;
    }
}
