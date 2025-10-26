package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ErrorMessage;
import racingcar.constant.RacingConstants;

public class InputProcessor {
    public static List<String> splitCarNames(String input) {
        validateInput(input);
        String[] inputNames = input.split(RacingConstants.INPUT_DELIMITER);
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
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateRoundRange(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_RANGE.getMessage());
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
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
        }
    }

    private static void validateEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME_INPUT.getMessage());
        }
    }
}
