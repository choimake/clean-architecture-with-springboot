package stubs.repositories.user;

import domain.user.IUser;
import domain.user.IUserRepository;

import java.io.IOException;

public class UserRepositoryAlwaysFailToSave implements IUserRepository {
    @Override
    public void save(IUser user) throws IOException {
        throw new IOException("always save fail");
    }
}
