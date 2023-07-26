package top.lldwb.prototypePattern;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

// 抽象原型类
@Data
abstract class Shape implements Cloneable {
    // 业务
    protected String name;

    abstract void draw();

    // 拷贝
    public Shape clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (Shape) clone;
    }
}

// 具体原型类
class ConcreteShape extends Shape {
    @Override
    void draw() {
        System.out.println("具体原型类的业务");
    }
}

// 原型管理器类
class PrototypeManager {
    private static Map<String, Shape> shapes = new HashMap<>();

    // 添加原型对象到管理器
    public static void addShape(String key, Shape shape) {
        shapes.put(key, shape);
    }

    // 获取原型对象
    public static Shape getShape(String key) {
        Shape prototype = shapes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 创建原型对象并添加到管理器
        Shape shapeA = new ConcreteShape();
        System.out.println("原型A的内存地址：" + System.identityHashCode(shapeA));
        PrototypeManager.addShape("shapeA", shapeA);

        // 通过原型管理器获取原型对象并进行复制
        Shape clonedShapeA = PrototypeManager.getShape("shapeA");
        if (clonedShapeA != null) {
            System.out.println("原型A复制的内存地址：" + System.identityHashCode(clonedShapeA));
            System.out.println("shapeA.equals(clonedShapeA)：" + shapeA.equals(clonedShapeA));
        } else {
            System.out.println("原型A复制未找到");
        }
    }
}