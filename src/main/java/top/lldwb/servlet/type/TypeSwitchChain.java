package top.lldwb.servlet.type;

import calculator.lldwb.top.util.ScanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 类型转换处理链
 *
 * @author 安然的尾巴
 * @version 1.0
 */
public class TypeSwitchChain {
    private Iterator<TypeSwitch> iterator;
    private static List<Class<?>> classList;

    static {
        classList =ScanUtils.scanImpl(TypeSwitch.class, "top.lldwb.servlet.type.impl");
    }

    public TypeSwitchChain() {
        List<TypeSwitch> list = new ArrayList<>();
        classList.forEach(clazz->{
            try {
                list.add((TypeSwitch) clazz.newInstance());
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        iterator = list.listIterator();
    }

    public Object doTypeSwitch(Field field, String value) {
        if (iterator.hasNext()) {
            TypeSwitch typeSwitch = iterator.next();
            return typeSwitch.valueOf(this, field, value);
        } else {
            throw new RuntimeException("没有对应的链");
        }
    }
}
