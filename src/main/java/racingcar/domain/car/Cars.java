package racingcar.domain.car;

import java.util.List;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    private Cars(final int nameValuesSize, final List<Car> cars) {
        validateNameDuplication(nameValuesSize, cars.size());
        this.cars = cars;
    }

    public static Cars from(final List<String> nameValues) {
        return new Cars(nameValues.size(), toUniqueCars(nameValues));
    }

    public void moveAll(final List<Integer> randomNumbers) {
        IntStream.range(0, size())
                .forEachOrdered(index -> cars.get(index)
                        .move(randomNumbers.get(index))
                );
    }

    public List<Name> getSamePositionCarNames(final Position position) {
        return cars.stream()
                .filter(car -> car.isSamePosition(position))
                .map(Car::name)
                .toList();
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(Car::copy)
                .toList();
    }

    public int size() {
        return cars.size();
    }

    private static List<Car> toUniqueCars(final List<String> nameValues) {
        return nameValues.stream()
                .distinct()
                .map(Car::new)
                .toList();
    }

    private void validateNameDuplication(final int nameValuesSize, final int uniqueCarsSize) {
        if (nameValuesSize != uniqueCarsSize) {
            throw new IllegalArgumentException("중복되지 않은 자동차 이름을 입력해주세요");
        }
    }

}
