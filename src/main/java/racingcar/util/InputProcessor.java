package racingcar.util;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {
    private static final String INPUT_DELIMITER = ",";

    public static List<String> splitCarNames(String input) {
        String[] inputNames = input.split(INPUT_DELIMITER);
        return processNames(inputNames);
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

    private static void validateEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 빈 값이 포함되어 있습니다.");
        }
    }
}
