package top.lldwb.spi;

// Cat.java
public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat: Meow!");
    }
}
