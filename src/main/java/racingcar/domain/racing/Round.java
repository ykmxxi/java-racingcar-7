package racingcar.domain.racing;

public class Round {

    private final int total;

    private Round(final int total) {
        this.total = total;
    }

    public static Round from(final int total) {
        validateRange(total);
        return new Round(total);
    }

    private static void validateRange(final int total) {
        if (total < 1 || total == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("자동차 경주는 1 라운드 이상 Integer.MAX_VALUE 미만 진행 가능합니다.");
        }
    }

}
