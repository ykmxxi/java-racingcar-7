package racingcar.presentation;

import racingcar.presentation.view.InputView;
import racingcar.service.RacingCarService;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(final RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        String carNamesInput = InputView.readCarNames();
        String tryCountInput = InputView.readTryCount();
//        racingCarService.startRacing(racingCarRequest);
    }

}
