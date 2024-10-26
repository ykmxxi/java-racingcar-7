package racingcar.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import racingcar.domain.car.Name;
import racingcar.domain.car.Position;
import racingcar.domain.racing.Result;
import racingcar.domain.racing.Results;

public final class RacingCarResponse {

    private final List<Map<String, Integer>> raceResults;
    private final List<String> winnerNames;

    private RacingCarResponse(List<Map<String, Integer>> raceResults, List<String> winnerNames) {
        this.raceResults = raceResults;
        this.winnerNames = winnerNames;
    }

    public static RacingCarResponse of(final Results results, final List<Name> winners) {
        List<Map<String, Integer>> raceResults = new ArrayList<>();
        for (Result result : results.getResults()) {
            Map<String, Integer> raceResult = new HashMap<>();
            for (Entry<Name, Position> entry : result.getResult().entrySet()) {
                raceResult.put(entry.getKey().value(), entry.getValue().value());
            }
            raceResults.add(raceResult);
        }
        List<String> winnerNames = winners.stream()
                .map(Name::value)
                .toList();
        return new RacingCarResponse(raceResults, winnerNames);
    }

    public List<Map<String, Integer>> raceResults() {
        return raceResults;
    }

    public List<String> winners() {
        return winnerNames;
    }

}
