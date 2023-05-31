package SimpleFactoryPattern;

class PigFactory implements AnimalFactory {
    @Override
    public Animal getAnimal() {
        return new Pig();
    }
}