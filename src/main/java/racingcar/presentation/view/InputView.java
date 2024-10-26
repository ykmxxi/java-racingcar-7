package racingcar.presentation.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            String input = Console.readLine();
            validateEmptyAndBlank(input);
            return input;
        } finally {
            Console.close();
        }
    }

    public static String readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            String input = Console.readLine();
            validateEmptyAndBlank(input);
            validateNumeric(input);
            return input;
        } finally {
            Console.close();
        }
    }

    private static void validateEmptyAndBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백(빈 문자열)을 입력할 수 없습니다.");
        }
    }

    private static void validateNumeric(final String input) {
        if (input.chars().anyMatch(Character::isLetter)) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }

}
