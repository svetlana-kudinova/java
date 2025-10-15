import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();

            String result = calc(input);
            System.out.println("Результат: " + result);

    }
    public static String calc(String input) {
        Pattern pattern = Pattern.compile("(\\d+)\\s*([+\\-*/])\\s*(\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            int num1 = Integer.parseInt(matcher.group(1));
            String operator = matcher.group(2);
            int num2 = Integer.parseInt(matcher.group(3));

            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("throws Exception");
            }

            // Выполнение операции в зависимости от оператора
            switch (operator) {
                case "+":
                    return String.valueOf(num1 + num2);
                case "-":
                    return String.valueOf(num1 - num2);
                case "*":
                    return String.valueOf(num1 * num2);
                case "/":
                    // Результат деления – целое число, остаток отбрасывается
                    return String.valueOf(num1 / num2);
                default:
                    throw new IllegalArgumentException("throws Exception");
            }
        } else {
            throw new IllegalArgumentException("throws Exception");
        }
    }


}
