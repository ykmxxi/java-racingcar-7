package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("이름 검증을 통과하면 자동차가 생성 된다")
    @Test
    void 자동차_생성_성공() {
        assertDoesNotThrow(() -> new Car("pobi"));
    }

    @DisplayName("이름 검증에 실패하면 자동차 생성을 실패한다")
    @ValueSource(strings = {"", " ", "pobi!"})
    @ParameterizedTest
    void 자동차_생성_실패_이름_검증_실패(String nameValue) {
        assertThatThrownBy(() -> new Car(nameValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
