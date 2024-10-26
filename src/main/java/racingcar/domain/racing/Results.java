package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

public class Results {

    private final List<Result> results;

    public Results() {
        this.results = new ArrayList<>();
    }

    public void saveAll(final List<Car> cars) {
        Result result = Result.empty();
        for (Car car : cars) {
            result.save(car.name(), car.position());
        }
        results.add(result);
    }

    public Position findWinnerPosition() {
        return results.getLast()
                .getResult()
                .values()
                .stream()
                .max(Position::compareTo)
                .orElse(Position.zero());
    }

    public List<Result> getResults() {
        return results.stream()
                .toList();
    }

}
