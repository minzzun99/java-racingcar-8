package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ErrorMessage;
import racingcar.constant.RacingConstants;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateLength(String name) {
        if (name.length() > RacingConstants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage(), RacingConstants.MAX_NAME_LENGTH));
        }
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(RacingConstants.RANDOM_MIN, RacingConstants.RANDOM_MAX);
        return randomNumber >= RacingConstants.MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}