package racingcar.constant;

public enum PrintMessage {
    INPUT_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_RACING_ROUND_MESSAGE("시도할 횟수는 몇 회인가요?"),
    ROUND_RESULT_MESSAGE("\n실행 결과"),
    WINNER_MESSAGE("최종 우승자 : "),
    CAR_STATUS_FORMAT("%s : %s%n"),
    POSITION_SYMBOL("-");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
