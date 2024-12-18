package com.chuwa.hw21;

public class Pizza {

    private final String size;
    private final String crust;

    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;

    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    public static class PizzaBuilder {
        private final String size;
        private final String crust;

        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean mushrooms = false;

        public PizzaBuilder(String size, String crust) {
            this.size = size;
            this.crust = crust;
        }

        public PizzaBuilder withCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder withPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public PizzaBuilder withMushrooms(boolean mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", crust=" + crust + ", cheese=" + cheese +
                ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + "]";
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("Large", "Thin")
                .withCheese(true)
                .withPepperoni(true)
                .withMushrooms(false)
                .build();

        System.out.println(pizza);
    }
}
