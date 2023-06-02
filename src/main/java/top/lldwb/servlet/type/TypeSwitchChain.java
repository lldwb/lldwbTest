package top.lldwb.servlet.type;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 类型转换处理链
 *
 * @author 安然的尾巴
 * @version 1.0
 */
public class TypeSwitchChain {
    List<TypeSwitch> list = new ArrayList<>();

    /**
     * 传入类型处理
     *
     * @param typeSwitch
     */
    public void addTypeSwitch(TypeSwitch typeSwitch) {
        list.add(typeSwitch);
    }

    public Object typeSwitch(Field field, String value) {
        for (TypeSwitch typeSwitch:list){
            Object object = typeSwitch.valueOf(field,value);
            if (object != null){
                return object;
            }
        }
        return null;
    }
}
