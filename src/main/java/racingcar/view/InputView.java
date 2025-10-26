package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.PrintMessage;

public class InputView {
    public static String requestCarName() {
        System.out.println(PrintMessage.INPUT_CAR_NAMES_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String requestRound() {
        System.out.println(PrintMessage.INPUT_RACING_ROUND_MESSAGE.getMessage());
        return Console.readLine();
    }
}
