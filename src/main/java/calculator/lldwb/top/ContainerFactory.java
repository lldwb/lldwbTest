package calculator.lldwb.top;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ContainerFactory {

    /**
     * 容器
     */
    private static Map<String, Object> container = new HashMap<>();

    /**
     * 在静态代码块中初始化整个容器工厂，解析properties文件中配置的对象，
     * 创建实例放入到Map集合中
     */
    static {
        // 返回输入流
        try (InputStream input = ContainerFactory.class.getClassLoader().getResourceAsStream("config.properties")){
            Properties prop = new Properties();
            // 加载并读取 properties 文件的内容
            prop.load(input);
            // 循环遍历prop对象，得到每一个properties的键值对
            prop.forEach((k, v) ->
                    // 将key和创建好的对象(将v通过newInstance方法创建实例)保存到容器中
                    container.put((String) k, newInstance((String) v))
            );
        } catch (Exception e) {
            throw new RuntimeException("解析失败:", e);
        }
    }

    /**
     * 创建实例
     * @param className 类的路径
     * @return
     */
    private static Object newInstance(String className) {
        try {
            return Class.forName(className).getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例创建失败:", e);
        }
    }

    /**
     * 容器工厂方法
     */
    public static <T> T getBean(String name) {
        return (T) container.get(name);
    }
}