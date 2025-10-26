package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("자동차 리스트 생성")
    void 자동차_리스트_생성() {
        List<Car> names = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        Cars cars = new Cars(names);

        assertThat(cars.getRacingCars()).hasSize(3);
        assertThat(cars.getRacingCars().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getRacingCars().get(1).getName()).isEqualTo("woni");
        assertThat(cars.getRacingCars().get(2).getName()).isEqualTo("jun");
    }
}
