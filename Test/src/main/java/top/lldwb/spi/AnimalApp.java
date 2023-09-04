package top.lldwb.spi;

import java.util.ServiceLoader;

public class AnimalApp {
    public static void main(String[] args) {
        // 使用ServiceLoader加载Animal接口的实现
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);

        // 遍历并使用每个实现
        for (Animal animal : serviceLoader) {
            animal.makeSound();
        }
    }
}
