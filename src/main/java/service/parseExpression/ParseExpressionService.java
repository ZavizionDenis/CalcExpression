package service.parseExpression;

import exceptions.NotFoundOpenBraketException;
import help.Operations;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseExpressionService implements IParseExpressionService
{
    public List<String> convertExpression (String inputExpression) throws NotFoundOpenBraketException {
        final String DIGITS_INT = "(\\d+)";
        final String DIGITS_DOUBLE = "(\\d+\\.\\d+)";
        final String OPERATION_SYMBOLS = "([" + Operations.getOperationSymbolsWithOutBrakets() + "])";
        final String BRAKETS = "([" + Operations.getBrakets() + "])";
        final String ELEMENT_EXPRESSION = DIGITS_DOUBLE + "|" + DIGITS_INT + "|" + OPERATION_SYMBOLS + "|" + BRAKETS;

        Matcher matcher = Pattern.compile(ELEMENT_EXPRESSION).matcher(inputExpression);
        Deque <Operations> operations = new ArrayDeque<>();
        List <String> outputExpression = new ArrayList<>();

        while (matcher.find()) {
            String nextElement = matcher.group();

            if (nextElement.matches(DIGITS_DOUBLE) || nextElement.matches(DIGITS_INT)) {
                outputExpression.add(nextElement);
            }

            if (nextElement.equals(Operations.OPEN_BRAKET.getOperationSymbol())) {
                operations.addFirst(Operations.OPEN_BRAKET);
            }

            if (nextElement.equals(Operations.CLOSE_BRAKET.getOperationSymbol())) {
                while (operations.peekFirst() != (Operations.OPEN_BRAKET)) {
                    try {
                        outputExpression.add(operations.pop().getOperationSymbol());
                    }catch (NoSuchElementException ex) {
                        throw new NotFoundOpenBraketException("Для закрывающей скобки не найдена открывающая скобка.");
                    }
                }
                operations.pollFirst();
            }

            if (nextElement.matches(OPERATION_SYMBOLS)) {
                Operations nextOperation = Operations.getOperationPerSymbol(nextElement);
                if (operations.peekFirst() != null && operations.peekFirst().getPriority() >= nextOperation.getPriority()) {
                    outputExpression.add(operations.pop().getOperationSymbol());
                }
                operations.addFirst(nextOperation);
            }
        }

        while (operations.peekFirst() != null) {
            outputExpression.add(operations.pollFirst().getOperationSymbol());
        }

        return outputExpression;
    }
}
