package calculator.lldwb.top.util;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 扫描工具类
 * 该工具类提供扫描包的方法，用于获取包中的类信息。
 *
 * @author 安然的尾巴
 * @version 1.0
 */
public class ScanUtil {

    /**
     * 扫描指定的包，并返回相关的Class对象
     *
     * @param packages 要扫描的包名
     * @return 包中的类对象列表
     */
    public static List<Class<?>> scan(String... packages) {
        // 使用try-with-resources语句，这可以自动关闭在其内部打开的资源，以防止资源泄漏
        try (ScanResult scan = new ClassGraph()
                // enableAllInfo()方法启用所有扫描信息，包括类信息、方法信息、字段信息等等
                .enableAllInfo()
                // acceptPackages(packages)方法接受一个包名字符串数组，扫描器只会扫描这些包及其子包
                .acceptPackages(packages)
                // 执行扫描
                .scan()) {
            // getAllClasses()方法获取扫描结果中的所有类
            // loadClasses()方法加载这些类并返回一个Class对象的数组
            return scan.getAllClasses().loadClasses();
        } // scan对象自动关闭
    }

    /**
     * 扫描指定的包，并返回指定接口的实现类对象
     *
     * @param clazz    接口类
     * @param packages 要扫描的包名
     * @return 实现指定接口的类对象列表
     */
    public static List<Class<?>> scan(Class<?> clazz, String... packages) {
        List<Class<?>> list = new ArrayList<>();
        // 遍历扫描到的每一个类
        ScanUtil.scan(packages).forEach(aClass -> {
            // 判断扫描到的类是否为指定接口的实现类，并排除接口自己
            if (clazz.isAssignableFrom(aClass) && clazz != aClass) {
                list.add(aClass);
            }
        });
        return list;
    }

    /**
     * 扫描指定的包，并返回带有指定注解的类对象
     *
     * @param annotation 指定的注解
     * @param packages   要扫描的包名
     * @return 带有指定注解的类对象列表
     */
    public static List<Class<?>> scan(Annotation annotation, String... packages) {
        List<Class<?>> list = new ArrayList<>();
        ScanUtil.scan(packages).forEach(aClass -> {
            // 判断扫描到的类是否带有指定的注解
            if (aClass.isAnnotation() && aClass.isAnnotationPresent(annotation.getClass())) {
                list.add(aClass);
            }
        });
        return list;
    }

    /**
     * 扫描指定的包，并返回实现了指定接口且带有指定注解的类
     *
     * @param clazz      接口类
     * @param annotation 指定的注解
     * @param packages   要扫描的包名
     * @return 实现了指定接口且带有指定注解的类对象列表
     */
    public static List<Class<?>> scan(Class<?> clazz, Annotation annotation, String... packages) {
        List<Class<?>> listImpl = ScanUtil.scan(clazz, packages);
        List<Class<?>> list = new ArrayList<>();
        listImpl.forEach(aClass -> {
            // 判断实现了指定接口的类是否带有指定的注解
            if (aClass.isAnnotation() && aClass.isAnnotationPresent(annotation.getClass())) {
                list.add(aClass);
            }
        });
        return list;
    }
}