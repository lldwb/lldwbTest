package top.lldwb.servlet;

import top.lldwb.servlet.type.TypeSwitchChain;

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
//        typeSwitchChain.addTypeSwitch(new StringSwitch());
//        typeSwitchChain.addTypeSwitch(new IntegerSwitch());
        try {
            T t = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                String key = field.getName();
                String value = req.getParameter(key);
                if (value != null && !value.isEmpty()) {
                    field.setAccessible(true);
                    field.set(t,new TypeSwitchChain().doTypeSwitch(field, value));
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
        Method method = clazz.getDeclaredMethod("valueOf", String.class);
        return method.invoke(null, value);
    }
}
