package top.lldwb.servlet;

import top.lldwb.servlet.type.TypeSwitchChain;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {
    /**
     * @param req   请求对象
     * @param clazz 实体类类型
     * @param <T>   实体类
     * @return
     */
    public static <T> T toBean(HttpServletRequest req, Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                String key = field.getName();
                if (req.getParameter(key) != null && !req.getParameter(key).isEmpty()) {
                    field.setAccessible(true);
                    if (field.getType().isArray()) {
                        String[] values = req.getParameterValues(key);
                        System.out.println(field.getType().getComponentType());
                        Object[] longs = BeanUtils.toArray(field.getType().getComponentType(), values);
                        field.set(t, longs);
                    } else {
                        String value = req.getParameter(key);
                        field.set(t, new TypeSwitchChain().doTypeSwitch(field.getType(), value));
                    }
                }
            }
            return t;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static Object[] toArray(Class<?> clazz, String[] values) throws InstantiationException, IllegalAccessException {
        Object[] objects = (Object[]) Array.newInstance(clazz,values.length);
        for(int i=0;i<values.length;i++){
            objects[i] =new TypeSwitchChain().doTypeSwitch(clazz, values[i]);
        }
        return objects;
    }
}
