package domain.user;

import java.io.IOException;

public interface IUserRepository {
    void save(IUser user) throws IOException;
}
