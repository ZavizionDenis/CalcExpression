package service.parseExpression;

import exceptions.NotFoundOpenBraketException;

import java.util.List;

public interface IParseExpressionService {
    List<String> convertExpression (String inputExpression) throws NotFoundOpenBraketException;
}
