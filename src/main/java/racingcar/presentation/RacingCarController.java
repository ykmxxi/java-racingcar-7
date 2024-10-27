package racingcar.presentation;

import java.util.Arrays;
import java.util.List;

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
        try {
            List<String> nameValues = getNameValues();
            int roundTotal = getRoundTotal();

            RacingCarResponse racingCarResponse = racingCarService.startRacing(nameValues, roundTotal);

            OutputView.printRacingCarResults(racingCarResponse);
        } finally {
            InputView.closeConsole();
        }
    }

    private List<String> getNameValues() {
        String carNamesInput = InputView.readCarNames();
        List<String> nameValues = Arrays.stream(carNamesInput.split(",", -1))
                .toList();
        validateNameValues(nameValues);
        return nameValues;
    }

    private void validateNameValues(final List<String> nameValues) {
        if (nameValues.stream()
                .anyMatch(String::isBlank)
        ) {
            throw new IllegalArgumentException("자동차 이름은 공백(빈 문자열)일 수 없습니다.");
        }
    }

    private int getRoundTotal() {
        try {
            String tryCount = InputView.readTryCount();
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해 주세요.");
        }
    }

}
