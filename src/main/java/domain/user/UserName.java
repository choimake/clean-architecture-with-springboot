package domain.user;

import java.util.Objects;

public class UserName {
    private final String value;

    public UserName(String value) {
        if (value == null) {
            throw new IllegalArgumentException("name is null");
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException("name is blank");
        }

        this.value = value;
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(value, userName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
