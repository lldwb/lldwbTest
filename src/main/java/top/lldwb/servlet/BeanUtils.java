package top.lldwb.servlet;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

public class BeanUtils {
    /**
     *
     * @param req
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> T toBean(HttpServletRequest req, Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                String key = field.getName();
                String value = req.getParameter(key);
                if (!value.isEmpty()) {
                    System.out.println(key);
                    System.out.println(value);
                    field.setAccessible(true);
                    if (field.getType() == String.class) {
                        field.set(t, value);
                    } else {
                        field.set(t, Integer.valueOf(value));
                    }
                }
            }
            return t;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 基本数据类型转包装类
     * @param fstype
     * @return
     */
    private static Object transition(String fstype){
        return null;
    }
}
