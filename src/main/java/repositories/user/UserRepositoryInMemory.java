package repositories.user;

import domain.user.IUser;
import domain.user.IUserFactory;
import domain.user.IUserRepository;

import java.io.IOException;
import java.util.ArrayList;

public final class UserRepositoryInMemory implements IUserRepository {

    private final IUserFactory factory;
    private ArrayList<IUser> userList = new ArrayList<>();

    // 自動採番用
    private static int sequence = 1;

    public UserRepositoryInMemory(IUserFactory factory)
    {
        this.factory = factory;
    }


    @Override
    public IUser save(IUser user) throws IOException {
        if (user == null) {
            throw new IOException("user is null");
        }

        var newUser = factory.create(sequence, user.name().value());
        userList.add(newUser);
        ++sequence;

        return newUser;
    }
}
