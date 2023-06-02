package top.lldwb.servlet.type.impl;

import top.lldwb.servlet.type.TypeSwitch;

import java.lang.reflect.Field;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class IntegerSwitch implements TypeSwitch {
    @Override
    public Object valueOf(Field field, String value) {
        if (field.getType() == Integer.class || field.getType() == Integer.TYPE) {
            return Integer.valueOf(value);
        } else {
            return null;
        }
    }
}
