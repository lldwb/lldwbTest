package Simple.Factory.Pattern;

class PigFactory implements AnimalFactory {
    @Override
    public Animal getAnimal() {
        return new Pig();
    }
}