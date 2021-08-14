package domain.user.impl;

import domain.user.IUser;

public final class User implements IUser {
    private String name;

    public User(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("name is empty or only whitespace");
        }

        this.name = name;
    }
}
