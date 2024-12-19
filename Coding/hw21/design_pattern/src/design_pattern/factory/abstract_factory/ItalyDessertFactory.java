package design_pattern.factory.abstract_factory;

public class ItalyDessertFactory implements DessertFactory {

    @Override
    public Coffee produceCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert produceDessert() {
        return new Trimisu();
    }
}
