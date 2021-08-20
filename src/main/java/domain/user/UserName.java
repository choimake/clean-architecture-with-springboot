package domain.user;

import java.util.Objects;

public class UserName {
    private final String name;

    public UserName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("name is blank");
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
