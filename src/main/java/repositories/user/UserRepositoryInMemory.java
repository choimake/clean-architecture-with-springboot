package repositories.user;

import domain.user.IUser;
import domain.user.IUserRepository;

import java.io.IOException;
import java.util.ArrayList;

public final class UserRepositoryInMemory implements IUserRepository {
    private ArrayList<IUser> userList = new ArrayList<>();

    @Override
    public void save(IUser user) throws IOException {
        if (user == null) {
            throw new IOException("user is null");
        }
        userList.add(user);
    }
}
