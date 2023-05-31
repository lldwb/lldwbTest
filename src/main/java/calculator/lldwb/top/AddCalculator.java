package calculator.lldwb.top;

import java.math.BigDecimal;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class AddCalculator implements Calculator{
    public double cal(double numA, double numB) {
        BigDecimal a = new BigDecimal(String.valueOf(numA));
        BigDecimal b = new BigDecimal(String.valueOf(numB));
        return a.add(b).doubleValue();
    }
}
