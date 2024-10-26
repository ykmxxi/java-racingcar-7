package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private static final int MOVE_FORWARD_THRESHOLD = 4;

    private final Name name;
    private Position position;

    public Car(final String nameValue) {
        this.name = Name.from(Objects.requireNonNull(nameValue));
        this.position = Position.zero();
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_THRESHOLD) {
            position = position.moveForward();
        }
    }

    public Position position() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
