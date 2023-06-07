package top.lldwb.abc;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class People {
    private People(){}

    /**
     * 使用静态内部类来创建一个唯一的外部类实例
     */
    private static class InnerClass{
        // 创建一个唯一的外部类实例
        private static final People INSTANCE = new People();
    }

    /**
     * 对外部提供一个公开的方法获取实例
     * @return
     */
    public static People getInstance(){
        // 当使用InnerClass时才会加载这个内部类，从而初始化People的实例
        return InnerClass.INSTANCE;
    }
}
