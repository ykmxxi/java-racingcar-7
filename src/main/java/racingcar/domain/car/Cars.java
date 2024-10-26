package racingcar.domain.car;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final Set<Car> cars;

    private Cars(final Set<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> nameValues) {
        Set<Car> uniqueCars = toUniqueCars(nameValues);
        validateNameDuplication(nameValues.size(), uniqueCars.size());
        return new Cars(uniqueCars);
    }

    private static Set<Car> toUniqueCars(final List<String> nameValues) {
        return nameValues.stream()
                .map(Car::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static void validateNameDuplication(final int nameValuesSize, final int uniqueCarsSize) {
        if (nameValuesSize != uniqueCarsSize) {
            throw new IllegalArgumentException("중복되지 않은 자동차 이름을 입력해주세요");
        }

    }

}
