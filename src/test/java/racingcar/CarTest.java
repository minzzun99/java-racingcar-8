package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;
import racingcar.constant.RacingConstants;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @ParameterizedTest
    @DisplayName("자동차 생성")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void 자동차_생성(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차의 위치 초기값 0")
    void 자동차의_위치_초기값_0() {
        Car car = new Car("abcd");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 예외 발생")
    void 자동차_이름_5자_초과_예외_발생() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage(),
                        RacingConstants.MAX_NAME_LENGTH));
    }
}
