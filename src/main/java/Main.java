import calcEngine.CalcEngine;
import service.parseExpression.IParseExpressionService;
import service.parseExpression.ParseExpressionService;
import service.expressionValidator.ExpressionValidService;
import service.expressionValidator.IExpressionValidService;
import service.console.ConsoleService;
import service.console.IConsoleService;

import java.util.List;

public class Main
{
    public static void main(String[] args) throws Exception {
        IConsoleService console = new ConsoleService();
        IExpressionValidService validService = new ExpressionValidService();
        String inputExpression = console.inputExpression();

        if (validService.isValidInputExpression(inputExpression)) {
            IParseExpressionService parseExpression = new ParseExpressionService();
            List <String> convertedExpression = parseExpression.convertExpression(inputExpression);
            CalcEngine calcEngine = new CalcEngine();
            console.outputResault(calcEngine.calculate(convertedExpression));
        }
    }
}
