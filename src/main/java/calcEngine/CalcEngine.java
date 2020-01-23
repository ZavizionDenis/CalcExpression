package calcEngine;

import exceptions.DivideByZeroException;
import exceptions.NotFoundNextOperandException;
import help.Operations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;

public class CalcEngine implements ICalcEngine {

    public BigDecimal calculate (List <String> convertedExpression) throws NotFoundNextOperandException, DivideByZeroException {
        Deque <BigDecimal> results = new ArrayDeque<>();

        for (String element : convertedExpression) {
            if (!element.matches("([" + Operations.getOperationSymbolsWithOutBrakets() + "])")) {
                results.addFirst(new BigDecimal(element));
            } else {
                Operations operation = Operations.getOperationPerSymbol(element);
                BigDecimal operand2;
                BigDecimal operand1;
                try {
                    operand2 = results.pop();
                    operand1 = results.pop();
                } catch (NoSuchElementException ex) {
                    throw new NotFoundNextOperandException("Для выволнения математической операции не хватает операндов.");
                }

                if (operation == Operations.PLUS) {
                    results.addFirst(plus(operand1, operand2));
                }

                if (operation == Operations.MINUS) {
                    results.addFirst(minus(operand1, operand2));
                }

                if (operation == Operations.MULTIPLIER) {
                    results.addFirst(multiplier(operand1, operand2));
                }

                if (operation == Operations.DIVISION) {
                    results.addFirst(divide(operand1, operand2));
                }

                if (operation == Operations.EXTENT) {
                    results.addFirst(extent(operand1, operand2));
                }
            }
        }
        return results.peekFirst();
    }

    @Override
    public BigDecimal plus(BigDecimal d1, BigDecimal d2) {
        return d1.add(d2);
    }

    @Override
    public BigDecimal minus(BigDecimal d1, BigDecimal d2) {
        return d1.subtract(d2);
    }

    @Override
    public BigDecimal multiplier(BigDecimal d1, BigDecimal d2) {
        return d1.multiply(d2);
    }

    @Override
    public BigDecimal divide(BigDecimal d1, BigDecimal d2) throws DivideByZeroException {
        if (d2.compareTo(BigDecimal.ZERO) == 0) {
            throw new DivideByZeroException("Деление на ноль запрещено.");
        }
        return d1.divide(d2, 5, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal extent(BigDecimal d1, BigDecimal d2) {
        return d1.pow(d2.intValue());
    }
}
