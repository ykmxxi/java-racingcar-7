package racingcar.domain.car;

import java.util.Objects;

public class Position {

    private static final Position ZERO = new Position(0);

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position zero() {
        return ZERO;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position position)) {
            return false;
        }
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
