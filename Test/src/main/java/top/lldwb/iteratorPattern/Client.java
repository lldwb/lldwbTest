package top.lldwb.iteratorPattern;

import java.util.ArrayList;
import java.util.List;

// 抽象迭代器接口
interface Iterator {
    boolean hasNext(); // 是否还有下一个元素

    Object next(); // 获取下一个元素
}

// 具体迭代器类
class ConcreteIterator implements Iterator {
    private List<Object> list; // 存储数据的集合
    private int index = 0; // 当前迭代器的位置

    ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public Object next() {
        if (this.hasNext()) {
            return list.get(index++);
        }
        return null;
    }
}

// 抽象聚合类
interface Aggregate {
    void add(Object obj); // 添加元素到集合

    void remove(Object obj); // 从集合中移除元素

    Iterator createIterator(); // 创建迭代器
}

// 具体聚合类
class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<>();

    public void add(Object obj) {
        list.add(obj);
    }

    public void remove(Object obj) {
        list.remove(obj);
    }

    public Iterator createIterator() {
        return new ConcreteIterator(list);
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.add("元素A");
        aggregate.add("元素B");
        aggregate.add("元素C");

        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
