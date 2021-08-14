package domain.user;

public interface IUserFactory {
    /**
     * create IUser instance.
     * @param name username.
     * @return IUser instance
     */
    IUser create(String name);
}
