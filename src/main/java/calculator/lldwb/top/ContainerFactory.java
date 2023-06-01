package calculator.lldwb.top;

import calculator.lldwb.top.util.ScanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ContainerFactory {

    /**
     * 单例容器
     */
    private static Map<String, Object> container = new HashMap<>();
    /**
     * 原型容器
     */
    private static Map<String, Class<?>> archetype = new HashMap<>();

    /**
     * 初始化容器
     * 参数表示要扫描的包路径
     */
    public ContainerFactory(String... packages) {
        List<Class<?>> classList = ScanUtils.scan(packages);
        resolveClass(classList);
    }

    /**
     * 解析class集合，找到带有@Bean注解的类
     */
    private void resolveClass(List<Class<?>> classList) {
        classList.forEach(clazz -> {
            if (clazz.isAnnotationPresent(Bean.class)) {
                Bean bean = clazz.getAnnotation(Bean.class);
                // 获取 Bean 的作为 k
                String k = bean.value();
                // 判断是否需要唯一
                if (bean.sole()) {
                    // 唯一，添加到单例容器
                    container.put(k, newInstance(clazz));
                } else {
                    // 不唯一，添加到原型容器
                    archetype.put(k, clazz);
                }
            }
        });
    }


    /**
     * 创建实例
     *
     * @param clazz 类
     * @return
     */
    private static Object newInstance(Class<?> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例创建失败:", e);
        }
    }

    /**
     * 容器工厂方法
     */
    public static <T> T getBean(String name) {
        // 判断单例容器中是否有
        if (container.containsKey(name)) {
            return (T) container.get(name);
        } else {
            return (T) newInstance(archetype.get(name));
        }
    }
}