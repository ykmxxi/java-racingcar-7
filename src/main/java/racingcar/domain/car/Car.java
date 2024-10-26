package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private final Name name;
    private Position position;

    public Car(final String nameValue) {
        this.name = Name.from(Objects.requireNonNull(nameValue));
        this.position = Position.zero();
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
