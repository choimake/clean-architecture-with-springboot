package domain.user.impl;

import domain.user.IUser;

public final class User implements IUser {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isValidName() {
        if (name == null) {
            return false;
        }
        if (name.isBlank()) {
            return false;
        }
        return true;
    }
}
