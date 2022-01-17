package domain.user;

import java.io.IOException;

public interface IUserRepository {
    /**
     * Save user.
     * @param user User instance
     * @return IUser User instance
     * @throws IOException If fail to save, throws Exception.
     */
    IUser save(IUser user) throws IOException;
}
