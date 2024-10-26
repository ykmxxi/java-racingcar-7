package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.Car;

public class Results {

    private final List<Result> results;

    public Results() {
        this.results = new ArrayList<>();
    }

    public void saveAll(final List<Car> cars) {
        for (Car car : cars) {
            Result result = Result.from(car.name(), car.position());
            results.add(result);
        }
    }

    public List<Result> getResults() {
        return results.stream()
                .toList();
    }

}
