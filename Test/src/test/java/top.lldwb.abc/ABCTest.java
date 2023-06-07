package top.lldwb.abc;

import org.junit.jupiter.api.Test;
import top.lldwb.servlet.User;

import java.lang.reflect.Field;

public class ABCTest {
    @Test
    public void fss() {
        System.out.println("E:\\我的世界\\测压工具\\EndMinecraftPlus-master".replaceAll("\\\\[^\\\\]*$", ""));
    }

    @Test
    public void f() {
        for (Field field : User.class.getDeclaredFields()) {
            String key = field.getName();
            System.out.println(key);
            System.out.println(field.getType().getName());
            System.out.println(Object[].class.isAssignableFrom(field.getType()));
            if (field.getType().isArray()){
                System.out.println(field.getType().getComponentType().getName());
            }
        }
        System.out.println(Object[].class.getName());
    }
}