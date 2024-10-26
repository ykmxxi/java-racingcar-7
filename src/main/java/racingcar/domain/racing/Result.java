package racingcar.domain.racing;

import java.util.HashMap;
import java.util.Map;

import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

public class Result {

    private final Map<Name, Position> result;

    public Result() {
        this.result = new HashMap<>();
    }

}
