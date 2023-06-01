package top.lldwb.servlet;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     * @param req
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(HttpServletRequest req, Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                String key = field.getName();
                String value = req.getParameter(key);
                if (!value.isEmpty()) {
                    field.setAccessible(true);
                    if (field.getType() == String.class) {
                        field.set(t, value);
                    } else {
                        field.set(t, valueOf(field.getType(),value));
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
     * String转包装类
     *
     * @param value
     * @return
     */
    private static Object valueOf(Class<?> clazz, String value) throws Exception {
        Method method = clazz.getDeclaredMethod("valueOf",String.class);
        return method.invoke(null,value);
    }
}
