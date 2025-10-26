package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.InputProcessor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private Cars racingCars;
    private int round;

    public void start() {
        setCars();
        setRound();
        startRace();
        printWinners();
    }

    private void setCars() {
        String input = InputView.requestCarName();
        List<Car> cars = InputProcessor.splitCarNames(input)
                .stream()
                .map(Car::new)
                .toList();

        this.racingCars = new Cars(cars);
    }

    private void setRound() {
        String input = InputView.requestRound();
        this.round = InputProcessor.parseRound(input);
    }

    private void startRace() {
        OutputView.printRoundResultMessage();
        for (int i = 0; i < round; i++) {
            racingCars.moveAll();
            printRoundResult();
        }
    }

    private void printRoundResult() {
        List<Car> cars = racingCars.getRacingCars();
        for (Car car : cars) {
            OutputView.printCarStatus(car.getName(), car.getPosition());
        }
        OutputView.printNewLine();
    }

    private void printWinners() {
        String winners = racingCars.getWinners();
        OutputView.printWinner(winners);
    }
}
