package service.expressionValidator;

import exceptions.InvalidElemetOfExpressionException;
import exceptions.RepeatSymbolOfOperationException;
import help.Help;
import help.Operations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidService implements IExpressionValidService
{

    public boolean isValidInputExpression(String expression) throws InvalidElemetOfExpressionException, RepeatSymbolOfOperationException {
       final String INVALID_SYMBOLS = "[^\\d." + Operations.getAllOperationSymbols() + "]";
       final String REPEAT_OPERATIONS = "[" + Operations.getOperationSymbolsWithOutBrakets()+ "]{2,}";

       Matcher matcher = Pattern.compile(INVALID_SYMBOLS).matcher(expression);
        if (matcher.find()) {
            throw new InvalidElemetOfExpressionException("В веденом выражении использованы недопустимые символы!\n" +
                    Help.EXPRESSION_FORMAT.getDescription());
        }

        matcher = Pattern.compile(REPEAT_OPERATIONS).matcher(expression);
        if (matcher.find()) {
            throw new RepeatSymbolOfOperationException("В веденом выражении дублируются символы операции! \n" +
                    Help.EXPRESSION_FORMAT.getDescription());
        }
        return true;
    }
}
