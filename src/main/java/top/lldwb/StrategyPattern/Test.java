package top.lldwb.StrategyPattern;

import calculator.lldwb.top.util.ScanUtils;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test() {
        Context context = new Context();
        double num = context.executeCalculator("add", 1, 1);
        System.out.println(num);
        System.out.println(context.executeCalculator("add", 1, 1));
        System.out.println(context.executeCalculator("div", 1, 1));
        System.out.println(context.executeCalculator("mul", 1, 1));
        System.out.println(context.executeCalculator("sub", 1, 1));

        ScanUtils.scanImpl(Calculator.class, "top.lldwb.StrategyPattern").forEach(clazz -> {
            System.out.println(clazz.getName());
        });
    }
}
