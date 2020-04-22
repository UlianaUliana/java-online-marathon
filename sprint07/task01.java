//  Suppose we have the next class:
//  class Pizza {
//      private String cheese;
//      private String meat;
//      private String seafood;
//      private String vegetable;
//      private String mushroom;
//
//      private Pizza() { }
//
//      public static PizzaBuilder base() {
//          return new PizzaBuilder();
//      }
//  }
//
//Create public static inner class named PizzaBuilder inside Pizza class that correspond
// the next class diagram:
//
//
//Inside the cook method create and return an instance of Pizza class with your
// favorite ingredients.

class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() { }

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }

    public static class PizzaBuilder {
        private Pizza pizza;
        private PizzaBuilder() {}
        public PizzaBuilder addCheese(String cheese) {
            pizza.cheese = cheese;
            return base();
        }
        public PizzaBuilder addMeat(String meat) {
            pizza.meat = meat;
            return base();
        }
        public PizzaBuilder addSeafood(String seafood) {
            pizza.seafood = seafood;
            return base();
        }
        public PizzaBuilder addVegetable(String vegetable) {
            pizza.vegetable = vegetable;
            return base();
        }
        public PizzaBuilder addMushroom (String mushroom) {
            pizza.mushroom = mushroom;
            return base();
        }
        public Pizza build() {
            return new Pizza();
        }

    }

}

class Oven {
    public static Pizza cook() {
        Pizza myPizza = Pizza.base().build();
        return myPizza;
    }
}
