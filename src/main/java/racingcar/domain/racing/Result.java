package racingcar.domain.racing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

public class Result {

    private final Map<Name, Position> result;

    private Result(final Map<Name, Position> result) {
        this.result = result;
    }

    public static Result from(final Name name, final Position position) {
        Map<Name, Position> result = new HashMap<>();
        result.put(name, position);
        return new Result(result);
    }

    public Map<Name, Position> getResult() {
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Result result1)) {
            return false;
        }
        return Objects.equals(getResult(), result1.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getResult());
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                '}';
    }

}
