package top.lldwb.abc;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.Set;

public class ABCTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        // 扫描IDataValidator所在的包 com.lm.validate
        Reflections reflections = new Reflections(ABC.class.getPackage().getName());
        // 获取包com.lm.validate下面所有IDataValidator实现类
        Set<Class<? extends ABC>> implClass = reflections.getSubTypesOf(ABC.class);
        for (Class clazz:implClass){
            System.out.println(clazz.getName());
            ABC abc = (ABC) clazz.newInstance();
            abc.output();
        }
    }
}