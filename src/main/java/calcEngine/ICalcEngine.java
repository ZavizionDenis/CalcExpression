package calcEngine;

import exceptions.DivideByZeroException;

import java.math.BigDecimal;

public interface ICalcEngine {

    BigDecimal plus (BigDecimal d1, BigDecimal d2);

    BigDecimal minus (BigDecimal d1, BigDecimal d2);

    BigDecimal multiplier (BigDecimal d1, BigDecimal d2);

    BigDecimal divide(BigDecimal d1, BigDecimal d2) throws DivideByZeroException;

    BigDecimal extent (BigDecimal d1, BigDecimal d2);

}
