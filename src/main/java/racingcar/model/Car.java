package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ErrorMessage;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final String name;
    private int position;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage(), MAX_NAME_LENGTH));
        }
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        return randomNumber >= MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}