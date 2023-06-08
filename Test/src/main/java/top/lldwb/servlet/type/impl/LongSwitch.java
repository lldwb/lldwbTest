package top.lldwb.servlet.type.impl;

import top.lldwb.servlet.type.TypeSwitch;
import top.lldwb.servlet.type.TypeSwitchChain;

/**
 * Integer类型转换
 *
 * @author 安然的尾巴
 * @version 1.0
 */
public class LongSwitch implements TypeSwitch {
    @Override
    public Object valueOf(TypeSwitchChain typeSwitchChain, Class<?> clazz, String value) {
        if (clazz == Long.class || clazz == Long.TYPE) {
            return Long.valueOf(value);
        } else {
            return typeSwitchChain.doTypeSwitch(clazz,value);
        }
    }
}
