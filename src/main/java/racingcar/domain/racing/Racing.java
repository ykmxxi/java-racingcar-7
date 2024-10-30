package racingcar.domain.racing;

import java.util.List;
import java.util.Objects;

import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

public class Racing {

    private final Cars cars;
    private final Results results;
    private final Round round;

    private Racing(final Cars cars, final int roundTotal) {
        this.cars = cars;
        this.results = Results.empty();
        this.round = Round.create(roundTotal);
    }

    public static Racing of(final Cars cars, final int roundTotal) {
        return new Racing(cars, roundTotal);
    }

    public void play(final List<Integer> numbers) {
        cars.moveAll(numbers);
    }

    public void saveRoundResult() {
        results.saveAll(cars.getCars());
    }

    public List<Name> announceWinners() {
        Position winnerPosition = results.findWinnerPosition();

        return Objects.requireNonNull(cars.getSamePositionCarNames(winnerPosition));
    }

    public Results results() {
        return results.copy();
    }

    public int roundTotal() {
        return round.total();
    }

}
