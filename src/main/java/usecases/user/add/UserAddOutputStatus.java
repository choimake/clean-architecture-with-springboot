package usecases.user.add;

public enum UserAddOutputStatus {
    SUCCESS,
    INPUT_IS_NULL,
    USER_NAME_IS_INVALID,
    FAIL_TO_SAVE_USER,
}
