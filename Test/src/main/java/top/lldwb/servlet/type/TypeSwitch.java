package top.lldwb.servlet.type;

import java.io.File;
import java.lang.reflect.Field;

/**
 * 类型转换接口
 *
 * @author 安然的尾巴
 * @version 1.0
 */
public interface TypeSwitch {
    /**
     * 可以处理返回值
     * 不可以处理返回 null
     *
     * @param clazz 类型
     * @param value 需要转换的值
     * @return
     */
    Object valueOf(TypeSwitchChain typeSwitchChain, Class<?> clazz, String value);
}
