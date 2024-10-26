package racingcar.service;

import java.util.List;
import java.util.stream.IntStream;

import racingcar.api.RandomsApiClient;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.racing.NumberRange;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.Results;
import racingcar.dto.RacingCarRequest;
import racingcar.dto.RacingCarResponse;

public class RacingCarService {

    public RacingCarResponse startRacing(RacingCarRequest request) {
        Cars cars = Cars.from(request.nameValues());
        Racing racing = Racing.from(request.roundTotal());

        for (int currentRound = 0; currentRound < request.roundTotal(); currentRound++) {
            List<Integer> randomNumbers = getRandomNumbers(cars.size());
            cars.moveAll(randomNumbers);

            racing.saveRoundResult(cars.getCars());
        }

        Results results = racing.getResults();
        List<Name> winners = racing.announceWinners(cars);
        return RacingCarResponse.of(results, winners);
    }

    private List<Integer> getRandomNumbers(final int carTotalCount) {
        return IntStream.range(0, carTotalCount)
                .mapToObj(randomNumber -> getRandomNumber())
                .toList();
    }

    private int getRandomNumber() {
        NumberRange movementRange = NumberRange.MOVEMENT_RANGE;
        return RandomsApiClient.getRandomNumber(movementRange.start(), movementRange.end());
    }

}
