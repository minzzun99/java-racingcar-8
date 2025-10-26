package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;
import racingcar.util.InputProcessor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputProcessorTest {
    @Test
    @DisplayName("자동차 이름 정상 분리")
    void 자동차_이름_정상_분리() {
        List<String> names = InputProcessor.splitCarNames("pobi,woni,jun");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름 공백 제거")
    void 자동차_이름_공백_제거() {
        List<String> names = InputProcessor.splitCarNames(" pobi , woni , jun ");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @DisplayName("빈값 입력 예외 발생")
    @ValueSource(strings = {"", " ", "    "})
    void 빈값_입력_예외_발생(String input) {
        assertThatThrownBy(() -> InputProcessor.splitCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
    }

    @Test
    @DisplayName("Null 입력 예외 발생")
    void Null_입력_예외_발생() {
        assertThatThrownBy(() -> InputProcessor.splitCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 빈값 포함 예외 발생")
    void 자동차_이름_빈값_포함_예외_발생() {
        assertThatThrownBy(() -> InputProcessor.splitCarNames("pobi, ,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME_INPUT.getMessage());
    }
}
