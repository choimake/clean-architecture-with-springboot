package domain.user.impl;

import domain.user.IUser;
import domain.user.UserId;
import domain.user.UserName;

public final class User implements IUser {
    private final UserId id;
    private final UserName name;

    public User(UserId id, UserName name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        this.id = id;
        this.name = name;
    }

    @Override
    public UserId id() {
        // idをストレージの自動採番で割り当てる場合、ストレージに新規登録する前の段階ではUserにはidが存在しない状態になる。
        // そのようなUserのidを参照する場合があるので、その際にはUserの使い方が正しくないものし、エラーとする。
        if (id == null) {
            throw new RuntimeException("id is null");
        }
        return this.id;
    }

    @Override
    public UserName name() {
        return this.name;
    }
}
