package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTest {

    @DisplayName("경주를 생성하면 빈 결과 저장 공간들과 총 라운드 횟수가 지정된다")
    @ValueSource(ints = {1, 100})
    @ParameterizedTest
    void 경주_생성_성공(int roundTotal) {
        assertDoesNotThrow(() -> Racing.from(roundTotal));
    }

    @DisplayName("총 라운드 횟수가 1 미만, 100 초과면 경주가 생성되지 않는다")
    @ValueSource(ints = {0, 101})
    @ParameterizedTest
    void 경주_생성_실패(int roundTotal) {
        assertThatThrownBy(() -> Racing.from(roundTotal))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 경주는 1 이상 100 이하의 라운드만 진행 가능합니다.");
    }

}
