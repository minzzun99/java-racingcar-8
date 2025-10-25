package racingcar.view;

public class OutputView {
    private static final String ROUND_RESULT_MESSAGE = "\n실행 결과";
    private static final String CAR_STATUS_FORMAT = "%s : %s%n";
    private static final String POSITION_SYMBOL = "-";
    private static final String WINNER_MESSAGE = "\n최종 우승자 : ";

    public static void printRoundResultMessage() {
        System.out.println(ROUND_RESULT_MESSAGE);
    }

    public static void printCarStatus(String carName, int position) {
        String positionFormat = POSITION_SYMBOL.repeat(position);
        System.out.printf(CAR_STATUS_FORMAT, carName, positionFormat);
    }

    public static void printWinner(String winners) {
        System.out.println(WINNER_MESSAGE + winners);
    }
}