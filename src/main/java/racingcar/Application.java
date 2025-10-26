package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        try {
            RacingController racingController = new RacingController();
            racingController.start();
        } finally {
            Console.close();
        }
    }
}
