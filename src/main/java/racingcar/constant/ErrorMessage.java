package racingcar.constant;

public enum ErrorMessage {
    INVALID_NUMBER_FORMAT("2,147,483,647 이하의 양수를 입력해주세요."),
    INVALID_ROUND_RANGE("시도할 횟수는 1 이상의 숫자를 입력해주세요."),
    NULL_OR_EMPTY_INPUT("값이 입력되지 않았습니다."),
    EMPTY_CAR_NAME_INPUT("자동차 이름에 빈 값이 포함되어 있습니다."),
    INVALID_CAR_NAME_LENGTH("자동차의 이름은 %d자 이하로 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
