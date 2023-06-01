package SimpleFactoryPattern;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class SuperFactory {
    public static <T> T create(String className){
        try {
            // 动态加载 class
            Class<?> clazz = Class.forName(className);
            // 利用 Class 对象来创建实例，先得到 class 中的构造器，然后再创建实例
            T instance = (T) clazz.getConstructor().newInstance();
            return instance;
        } catch (Exception e) {
            // 异常重抛
            throw new RuntimeException("Create instance fail.",e);
        }
    }
}
