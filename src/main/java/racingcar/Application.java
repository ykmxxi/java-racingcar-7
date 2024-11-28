package racingcar;

import racingcar.presentation.RacingCarClient;
import racingcar.presentation.view.InputView;
import racingcar.presentation.view.ResultView;
import racingcar.service.RacingCarService;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingCarService racingCarService = new RacingCarService();

        RacingCarClient racingCarClient = new RacingCarClient(
                inputView,
                resultView,
                racingCarService
        );

        racingCarClient.run();
    }

}
