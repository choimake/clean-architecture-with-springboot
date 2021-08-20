package domain.user;

public interface IUser {
    /**
     * Returns the UserId.
     * @return id of User
     */
    UserId id();
    /**
     * Returns the UserName.
     * @return name of User
     */
    UserName name();
}
