package top.lldwb.spi;

// Dog.java
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog: Woof! Woof!");
    }
}
