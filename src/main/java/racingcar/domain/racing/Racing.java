package racingcar.domain.racing;

public class Racing {

    private final Results results;
    private final Round round;

    private Racing(final int roundTotal) {
        this.results = new Results();
        this.round = Round.from(roundTotal);
    }

    public static Racing from(final int roundTotal) {
        return new Racing(roundTotal);
    }

}
