package racingcar.domain.car;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    private Cars(final int nameValuesSize, final List<Car> cars) {
        validateEmptyCarNameInputs(nameValuesSize);
        validateNameDuplication(nameValuesSize, cars.size());
        this.cars = Objects.requireNonNull(cars);
    }

    public static Cars from(final List<String> carNameInputs) {
        return new Cars(carNameInputs.size(), toUniqueCars(carNameInputs));
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

    private static List<Car> toUniqueCars(final List<String> carNameInputs) {
        return carNameInputs.stream()
                .distinct()
                .map(Car::new)
                .toList();
    }

    private void validateEmptyCarNameInputs(final int carNameInputsSize) {
        if (carNameInputsSize == 0) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
        }
    }

    private void validateNameDuplication(final int carNameInputsSize, final int uniqueCarsSize) {
        if (carNameInputsSize != uniqueCarsSize) {
            throw new IllegalArgumentException("중복되지 않은 자동차 이름을 입력해주세요.");
        }
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(Car::copy)
                .toList();
    }

    public int size() {
        return cars.size();
    }

}
