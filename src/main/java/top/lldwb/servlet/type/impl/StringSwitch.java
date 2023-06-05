package top.lldwb.servlet.type.impl;

import top.lldwb.servlet.type.TypeSwitch;
import top.lldwb.servlet.type.TypeSwitchChain;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class StringSwitch implements TypeSwitch {
    @Override
    public Object valueOf(TypeSwitchChain typeSwitchChain, Field field, String value) {
        if (field.getType() == String.class) {
            return value;
        } else {
            return typeSwitchChain.doTypeSwitch(field,value);
        }
    }
}
