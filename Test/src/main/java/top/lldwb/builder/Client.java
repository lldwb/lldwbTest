package top.lldwb.builder;

// 产品类
class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println("Product parts:");
        System.out.println("Part A: " + partA);
        System.out.println("Part B: " + partB);
        System.out.println("Part C: " + partC);
    }
}

// 抽象建造者类
abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult() {
        return product;
    }
}

// 具体建造者类
class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("PartC");
    }
}

// 指挥者类
class Director {
    public Product construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director();
        Product product = director.construct(builder);
        product.show();
    }
}