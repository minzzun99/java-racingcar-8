package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;
import racingcar.util.InputProcessor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputProcessorTest {
    @Nested
    @DisplayName("자동차 이름 관련 테스트")
    class CarNameTest {
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

        @Test
        @DisplayName("중복된 자동차 이름 예외 발생")
        void 중복된_자동차_이름_예외_발생() {
            assertThatThrownBy(() -> InputProcessor.splitCarNames("pobi,pobi"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }


    @Nested
    @DisplayName("시행 횟수 입력 관련 테스트")
    class RoundTest {
        @Test
        @DisplayName("시행 횟수 정상 입력")
        void 시행_횟수_정상_입력() {
            int round = InputProcessor.parseRound("5");
            assertThat(round).isEqualTo(5);
        }

        @Test
        @DisplayName("시행 횟수 공백 제거")
        void 시행_횟수_공백_제거() {
            int round = InputProcessor.parseRound(" 5 ");
            assertThat(round).isEqualTo(5);
        }

        @ParameterizedTest
        @DisplayName("양수가 아닌 숫자 입력 예외 발생")
        @ValueSource(strings = {"0", "-1", "-100"})
        void 양수가_아닌_숫자_입력_예외_발생(String round) {
            assertThatThrownBy(() -> InputProcessor.parseRound(round))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_ROUND_RANGE.getMessage());
        }

        @ParameterizedTest
        @DisplayName("숫자가 아닌 입력 또는 Integer 범위 초과 입력 예외 발생")
        @ValueSource(strings = {"a", "ab", "가나다", "999999999999"})
        void 숫자가_아닌_입력_또는_Integer_범위_초과_입력_예외_발생(String round) {
            assertThatThrownBy(() -> InputProcessor.parseRound(round))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }

        @ParameterizedTest
        @DisplayName("시행 횟수 빈값 입력 예외 발생")
        @ValueSource(strings = {"", " ", "   "})
        void 시행_횟수_빈값_입력_예외_발생(String round) {
            assertThatThrownBy(() -> InputProcessor.parseRound(round))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
        }

        @Test
        @DisplayName("시행 횟수 Null 입력 예외 발생")
        void 시행_횟수_Null_입력_예외_발생() {
            assertThatThrownBy(() -> InputProcessor.parseRound(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
        }
    }
}
