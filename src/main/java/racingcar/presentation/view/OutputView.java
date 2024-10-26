package racingcar.presentation.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private static final String DELIMITER = " : ";

    private OutputView() {}

    public static void printRaceResults(final List<Map<String, Integer>> raceResults) {
        System.out.println("실행 결과");
        for (Map<String, Integer> raceResult : raceResults) {
            for (Entry<String, Integer> entry : raceResult.entrySet()) {
                System.out.println(String.join(DELIMITER, entry.getKey(), "-".repeat(entry.getValue())));
            }
            System.out.println();
        }
    }

    public static void printWinnerNames(final List<String> winnerNames) {
        System.out.println(String.join(DELIMITER, "최종 우승자", String.join(",", winnerNames)));
    }

}
