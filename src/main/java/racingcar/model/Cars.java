package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String WINNERS_DELIMITER = ", ";

    private final List<Car> racingCars;

    public Cars(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public void moveAll() {
        for (Car car : racingCars) {
            car.move();
        }
    }

    public List<Car> getRacingCars() {
        return new ArrayList<>(racingCars);
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(WINNERS_DELIMITER));
    }

    private int getMaxPosition() {
        return racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
