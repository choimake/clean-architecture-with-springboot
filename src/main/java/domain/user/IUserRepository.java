package domain.user;

import java.io.IOException;

public interface IUserRepository {
    /**
     * Save user.
     * @param user User instance
     * @throws IOException If fail to save, throws Exception.
     */
    void save(IUser user) throws IOException;
}
