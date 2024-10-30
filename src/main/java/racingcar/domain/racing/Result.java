package racingcar.domain.racing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

public class Result {

    private final Map<Name, Position> result;

    private Result() {
        this.result = new LinkedHashMap<>();
    }

    public static Result empty() {
        return new Result();
    }

    public void save(final Name name, final Position position) {
        result.put(name, position);
    }

    public Map<Name, Position> getResult() {
        return result.entrySet()
                .stream()
                .collect(Collectors.toUnmodifiableMap(
                        Map.Entry::getKey,
                        entry -> {
                            Position position = entry.getValue();
                            return Position.from(position.value());
                        }
                ));
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
