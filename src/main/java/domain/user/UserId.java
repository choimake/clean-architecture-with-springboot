package domain.user;

import java.util.Objects;

public record UserId(int value) {
    public UserId {
        if (value <= 0) {
            throw new IllegalArgumentException("id is less than 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return Objects.equals(value, userId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
