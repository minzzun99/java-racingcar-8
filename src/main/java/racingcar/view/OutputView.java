package racingcar.view;

import racingcar.constant.PrintMessage;

public class OutputView {
    public static void printRoundResultMessage() {
        System.out.println(PrintMessage.ROUND_RESULT_MESSAGE.getMessage());
    }

    public static void printCarStatus(String carName, int position) {
        String positionFormat = PrintMessage.POSITION_SYMBOL.getMessage().repeat(position);
        System.out.printf(PrintMessage.CAR_STATUS_FORMAT.getMessage(), carName, positionFormat);
    }

    public static void printWinner(String winners) {
        System.out.println(PrintMessage.WINNER_MESSAGE.getMessage() + winners);
    }

    public static void printNewLine() {
        System.out.println();
    }
}