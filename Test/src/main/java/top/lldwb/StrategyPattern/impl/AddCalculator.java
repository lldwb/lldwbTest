package top.lldwb.StrategyPattern.impl;

import top.lldwb.StrategyPattern.Calculator;
import top.lldwb.StrategyPattern.anno.Bean;

import java.math.BigDecimal;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Bean("add")
public class AddCalculator implements Calculator {
    public double cal(double numA, double numB) {
        BigDecimal a = new BigDecimal(String.valueOf(numA));
        BigDecimal b = new BigDecimal(String.valueOf(numB));
        return a.add(b).doubleValue();
    }
}
