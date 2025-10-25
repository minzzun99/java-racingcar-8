package racingcar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;
    private int position;

    public Car(String name) {
        String processedName = name.strip();
        validateName(processedName);
        this.name = processedName;
        this.position = 0;
    }

    private void validateName(String name) {
        validateNullOrEmpty(name);
        validateLength(name);
    }

    private void validateNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주세요.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 " + MAX_NAME_LENGTH + "자 이하로 입력해주세요.");
        }
    }
}