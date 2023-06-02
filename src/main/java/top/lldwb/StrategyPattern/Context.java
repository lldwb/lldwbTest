package top.lldwb.StrategyPattern;

import calculator.lldwb.top.ContainerFactory;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class Context {
    private static String PKG_NAME = "top.lldwb.StrategyPattern";
    private static ContainerFactory containerFactory;

    static {
        containerFactory = new ContainerFactory(PKG_NAME);
    }

    public double executeCalculator(String type, double numA, double numB) {
        Calculator calculator = containerFactory.getBean(type);
        if (calculator == null) {
            throw new RuntimeException("并没有找到计算方法");
        }
        return calculator.cal(numA, numB);
    }
}
