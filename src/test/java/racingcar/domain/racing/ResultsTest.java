package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;

class ResultsTest {

    @DisplayName("경주 결과들은 자동차들의 입력 순서를 보장하며 모두 저장된다")
    @Test
    void 자동차들의_경주_결과들을_저장() {
        Results results = new Results();
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        results.saveAll(List.of(pobi, woni));

        assertThat(results.getResults()).containsExactly(
                createResult(pobi),
                createResult(woni)
        );
    }

    @DisplayName("조회를 위해 반환한 자동차들의 경주 결과들은 수정이 불가능하다")
    @Test
    void 자동차들의_경주_결과들_복사본은_수정_불가() {
        Results results = new Results();
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        results.saveAll(List.of(pobi, woni));

        List<Result> copyResults = results.getResults();

        assertThatThrownBy(copyResults::removeFirst)
                .isInstanceOf(UnsupportedOperationException.class);
    }

    private Result createResult(Car car) {
        return Result.from(car.name(), car.position());
    }

}
