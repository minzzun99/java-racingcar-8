package racingcar.util;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {
    private static final String INPUT_DELIMITER = ",";

    public static List<String> splitCarNames(String input) {
        validateInput(input);
        String[] inputNames = input.split(INPUT_DELIMITER);
        return processNames(inputNames);
    }

    public static int parseRound(String input) {
        validateInput(input);
        int round = convertToInt(input);
        validateRoundRange(round);
        return round;
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("2,147,483,647 이하의 양수를 입력해주세요.");
        }
    }

    private static void validateRoundRange(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상의 숫자를 입력해주세요.");
        }
    }

    private static List<String> processNames(String[] inputNames) {
        List<String> carNames = new ArrayList<>();
        for (String name : inputNames) {
            String processedName = name.strip();
            validateEmptyName(processedName);
            carNames.add(processedName);
        }
        return carNames;
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주세요.");
        }
    }

    private static void validateEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 빈 값이 포함되어 있습니다.");
        }
    }
}
