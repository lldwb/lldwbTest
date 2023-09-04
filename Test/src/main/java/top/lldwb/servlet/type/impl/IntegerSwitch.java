package top.lldwb.servlet.type.impl;

import top.lldwb.servlet.type.TypeSwitch;
import top.lldwb.servlet.type.TypeSwitchChain;

import java.lang.reflect.Field;

/**
 * Integer类型转换
 *
 * @author 安然的尾巴
 * @version 1.0
 */
public class IntegerSwitch implements TypeSwitch {
    @Override
    public Object valueOf(TypeSwitchChain typeSwitchChain, Class<?> clazz, String value) {
        if (clazz == Integer.class || clazz == Integer.TYPE) {
            return Integer.valueOf(value);
        } else {
            return typeSwitchChain.doTypeSwitch(clazz, value);
        }
    }
}
