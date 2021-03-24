package service.expressionValidator;

import exceptions.InvalidElemetOfExpressionException;
import exceptions.RepeatSymbolOfOperationException;

public interface IExpressionValidService {

    boolean isValidInputExpression(String expression) throws InvalidElemetOfExpressionException, RepeatSymbolOfOperationException;
}
