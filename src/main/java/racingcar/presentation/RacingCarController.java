package racingcar.presentation;

import racingcar.service.RacingCarService;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(final RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        // TODO: 이름 입력, 총 라운드 입력 RacingCarRequest 변환
//        racingCarService.startRacing(racingCarRequest);
    }

}
