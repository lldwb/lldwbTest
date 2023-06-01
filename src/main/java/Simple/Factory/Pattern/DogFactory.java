package Simple.Factory.Pattern;

class DogFactory implements AnimalFactory {
    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}