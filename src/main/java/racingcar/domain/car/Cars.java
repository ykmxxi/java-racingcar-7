package racingcar.domain.car;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> nameValues) {
        List<Car> uniqueCars = toUniqueCars(nameValues);
        validateNameDuplication(nameValues.size(), uniqueCars.size());
        return new Cars(uniqueCars);
    }

    private static List<Car> toUniqueCars(final List<String> nameValues) {
        return nameValues.stream()
                .distinct()
                .map(Car::new)
                .toList();
    }

    private static void validateNameDuplication(final int nameValuesSize, final int uniqueCarsSize) {
        if (nameValuesSize != uniqueCarsSize) {
            throw new IllegalArgumentException("중복되지 않은 자동차 이름을 입력해주세요");
        }

    }

    public void moveAll(final List<Integer> randomNumbers) {
        cars.forEach(car -> {
            car.move(randomNumbers.getFirst());
            randomNumbers.removeFirst();
        });
    }

    public int size() {
        return cars.size();
    }

}
