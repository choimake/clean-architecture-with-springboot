package domain.user;

public interface IUserFactory {
    /**
     * Create IUser instance.
     * @param name UserName
     * @return IUser instance
     */
    IUser create(String name);
}
