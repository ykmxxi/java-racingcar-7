package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private List<String> nameValues;

    @BeforeEach
    void setUp() {
        nameValues = new ArrayList<>(List.of("pobi", "woni", "jun"));
    }

    @DisplayName("자동차들의 이름에 중복이 없으면 자동차들이 생성된다")
    @Test
    void 자동차들_생성_성공() {
        assertDoesNotThrow(() -> Cars.from(nameValues));
    }

    @DisplayName("자동차들의 이름에 중복이 존재하면 자동차들 생성에 실패한다")
    @Test
    void 자동차들_생성_실패_중복_이름_존재() {
        nameValues.add("pobi");

        assertThatThrownBy(() -> Cars.from(nameValues))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 자동차 이름을 입력해주세요");
    }

    @DisplayName("조회를 위해 반환한 자동차들은 수정이 불가능하다")
    @Test
    void 조회를_위한_자동차들_복사본_수정_불가() {
        Cars cars = Cars.from(nameValues);

        List<Car> copyCars = cars.getCars();

        assertThatThrownBy(copyCars::removeFirst)
                .isInstanceOf(UnsupportedOperationException.class);
    }

}
