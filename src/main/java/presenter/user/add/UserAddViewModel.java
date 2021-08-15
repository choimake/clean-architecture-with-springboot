package presenter.user.add;

public class UserAddViewModel {
    private final String userName;
    private final String timestamp;

    public UserAddViewModel(String userName, String timestamp) {
        this.userName = userName;
        this.timestamp = timestamp;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getTimestamp() {
        return this.timestamp;
    }
}

