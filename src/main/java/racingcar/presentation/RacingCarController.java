package racingcar.presentation;

import java.util.Arrays;
import java.util.List;

import racingcar.dto.RacingCarRequest;
import racingcar.dto.RacingCarResponse;
import racingcar.presentation.view.InputView;
import racingcar.presentation.view.OutputView;
import racingcar.service.RacingCarService;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(final RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        String carNamesInput = InputView.readCarNames();
        String tryCountInput = InputView.readTryCount();
        InputView.closeConsole();

        RacingCarResponse racingCarResponse = racingCarService.startRacing(
                createRacingCarRequest(carNamesInput, tryCountInput)
        );

        OutputView.printRaceResults(racingCarResponse.raceResults());
        OutputView.printWinnerNames(racingCarResponse.winners());
    }

    private RacingCarRequest createRacingCarRequest(final String carNames, final String tryCount) {
        List<String> nameValues = Arrays.stream(carNames.split(",", -1))
                .toList();
        validateNameValuesInput(nameValues);
        int roundTotal = validateIntegerNumber(tryCount);
        return new RacingCarRequest(nameValues, roundTotal);
    }

    private void validateNameValuesInput(final List<String> nameValues) {
        if (nameValues.stream()
                .anyMatch(String::isBlank)
        ) {
            throw new IllegalArgumentException("자동차 이름은 공백(빈 문자열)일 수 없습니다.");
        }
    }

    private int validateIntegerNumber(final String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해 주세요.");
        }
    }

}
