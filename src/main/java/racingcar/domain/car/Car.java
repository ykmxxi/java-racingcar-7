package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private final Name name;
    private Position position;

    public Car(final String nameValue) {
        this.name = Name.from(Objects.requireNonNull(nameValue));
        this.position = Position.zero();
    }

}
