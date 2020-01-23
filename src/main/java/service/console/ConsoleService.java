package service.console;

import help.Help;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleService implements IConsoleService
{

    public String inputExpression() {
        System.out.printf("%s Введите выражение для вычисления:%n", Help.EXPRESSION_FORMAT.getDescription());
        final String NEGATIV_DIGITS = "^-\\d+\\.?\\d*|\\(-\\d+\\.?\\d*";

        String expression = new Scanner(System.in).nextLine().replaceAll("\\s+","");
        StringBuilder inputExpression = new StringBuilder(expression);

        Matcher matcher = Pattern.compile(NEGATIV_DIGITS).matcher(inputExpression);

        while (matcher.find()) {
            if (matcher.group().startsWith("(")) {
                inputExpression.insert(matcher.start() + 1, "0");
            } else {
                inputExpression.insert(matcher.start(), "0");
            }
        }
        return inputExpression.toString();
    }

    public void outputResault(BigDecimal resault) {
        System.out.println("Результат вычисления: " + resault);
    }
}
