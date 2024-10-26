package racingcar.domain.racing;

import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

public class Racing {

    private final Results results;
    private final Round round;

    private Racing(final int roundTotal) {
        this.results = new Results();
        this.round = Round.from(roundTotal);
    }

    public static Racing from(final int roundTotal) {
        return new Racing(roundTotal);
    }

    public void saveRoundResult(final List<Car> cars) {
        results.saveAll(cars);
    }

    public List<Name> announceWinners(final Cars cars) {
        Position winnerPosition = results.findWinnerPosition();

        return cars.getSamePositionCarNames(winnerPosition);
    }

}
