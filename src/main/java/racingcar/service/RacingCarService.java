package racingcar.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import racingcar.api.RandomsApiClient;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.racing.NumberRange;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.Results;
import racingcar.dto.RacingCarResponse;

public class RacingCarService {

    public RacingCarResponse startRacing(final List<String> nameValues, final int roundTotal) {
        Cars cars = Cars.from(nameValues);
        Racing racing = Racing.from(cars, roundTotal);

        playRacingCar(racing, cars.size());

        return Objects.requireNonNull(getRacingCarResponse(racing));
    }

    private void playRacingCar(final Racing racing, final int carsSize) {
        for (int currentRound = 0; currentRound < racing.roundTotal(); currentRound++) {
            List<Integer> randomNumbers = Objects.requireNonNull(getRandomNumbers(carsSize));

            racing.play(randomNumbers);
            racing.saveRoundResult();
        }
    }

    private List<Integer> getRandomNumbers(final int carTotalCount) {
        return IntStream.range(0, carTotalCount)
                .mapToObj(randomNumber -> createRandomNumber())
                .toList();
    }

    private RacingCarResponse getRacingCarResponse(final Racing racing) {
        Results results = racing.results();
        List<Name> winners = racing.announceWinners();

        return RacingCarMessageMapper.toResponse(results, winners);
    }

    private int createRandomNumber() {
        NumberRange movementRange = NumberRange.RANDOM_NUMBER_RANGE;
        return RandomsApiClient.getRandomNumber(movementRange.start(), movementRange.end());
    }

}
