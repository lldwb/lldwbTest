package top.lldwb.StrategyPattern;

import calculator.lldwb.top.util.ScanUtil;

import java.io.*;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class Test implements Cloneable, Serializable {
    private String name;

    @org.junit.jupiter.api.Test
    public void test() {
        Context context = new Context();
        double num = context.executeCalculator("add", 1, 1);
        System.out.println(num);
        System.out.println(context.executeCalculator("add", 1, 1));
        System.out.println(context.executeCalculator("div", 1, 1));
        System.out.println(context.executeCalculator("mul", 1, 1));
        System.out.println(context.executeCalculator("sub", 1, 1));

        ScanUtil.scan(Calculator.class, "top.lldwb.StrategyPattern").forEach(clazz -> {
            System.out.println(clazz.getName());
        });
    }

    /**
     * 重写clone()方法
     *
     * @return
     */
    public Object clone() {
        Test test = new Test();
        test.name = this.name;
        return test;
    }

    @org.junit.jupiter.api.Test
    public void testt() {
        try {
            Test test = new Test();
            test.name = "test";
            System.out.println("原生");
            System.out.println(test);
            System.out.println(test.name);

            System.out.println("拷贝引用");
            Test test1 = test;
            System.out.println(test1);
            System.out.println(test1.name);

            System.out.println("浅拷贝");
            //这里先讲一下浅拷贝，浅拷贝会创建一个新对象，新对象和原对象本身没有任何关系，新对象和原对象不等，但是新对象的属性和老对象相同。具体可以看如下区别：
            //如果属性是基本类型(int,double,long,boolean等)，拷贝的就是基本类型的值；
            //如果属性是引用类型，拷贝的就是内存地址（即复制引用但不复制引用的对象） ，因此如果其中一个对象改变了这个地址，就会影响到另一个对象。
            Test test2 = (Test) test.clone();
            System.out.println(test2);
            System.out.println(test2.name);

            System.out.println("深拷贝");
            //在对引用数据类型进行拷贝的时候，创建了一个新的对象，并且复制其内的成员变量。

            //在内存中创建一个字节数组缓冲区，所有发送到输出流的数据保存在该字节数组中
            //默认创建一个大小为32的缓冲区
            ByteArrayOutputStream byOut = new ByteArrayOutputStream();
            //对象的序列化输出
            ObjectOutputStream outputStream = new ObjectOutputStream(byOut);//通过字节数组的方式进行传输
            outputStream.writeObject(test);  //将当前student对象写入字节数组中

            //在内存中创建一个字节数组缓冲区，从输入流读取的数据保存在该字节数组缓冲区
            ByteArrayInputStream byIn = new ByteArrayInputStream(byOut.toByteArray()); //接收字节数组作为参数进行创建
            ObjectInputStream inputStream = new ObjectInputStream(byIn);
            Test test3 = (Test) inputStream.readObject(); //从字节数组中读取

            System.out.println(test3);
            System.out.println(test3.name);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
