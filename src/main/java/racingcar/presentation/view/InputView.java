package racingcar.presentation.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    private InputView() {}

    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return readInputLine();
    }

    public static String readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String inputLine = readInputLine();
        validateNumeric(inputLine);
        return inputLine;
    }

    public static void closeConsole() {
        Console.close();
    }

    private static String readInputLine() {
        String inputLine = Console.readLine();
        validateEmptyAndBlank(inputLine);
        return inputLine;
    }

    private static void validateEmptyAndBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백(빈 문자열)을 입력할 수 없습니다.");
        }
    }

    private static void validateNumeric(final String input) {
        if (input.chars()
                .anyMatch(Character::isLetter)
        ) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }

}
