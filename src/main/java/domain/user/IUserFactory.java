package domain.user;

public interface IUserFactory {

    /**
     * Create IUser instance.
     * For load User from Repository.
     * @param id UserId
     * @param name UserName
     * @return IUser instance
     */
    IUser create(int id, String name);

    /**
     * Create IUser instance.
     * For new User Registration.
     * @param name UserName
     * @return IUser instance
     */
    IUser create(String name);
}
