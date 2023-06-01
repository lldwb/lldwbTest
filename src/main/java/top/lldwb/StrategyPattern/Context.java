package top.lldwb.StrategyPattern;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class Context {
    private Calculator calculator;
    public Context(Calculator calculator){
        this.calculator = calculator;
    }
    public double executeCalculator(double numA, double numB){
        return calculator.cal(numA,numB);
    }
}
