//Create interface DrinkReceipt with methods String getName() and DrinkReceipt
// addComponent(String componentName, int componentCount). Create interface DrinkPreparation
// with method Map<String, Integer> makeDrink() to return a drink components.
// Create interface Rating with method int getRating().
//Class Caffee contains fields String name, int rating, Map of ingredients and implements
// interfaces DrinkReceipt, DrinkPreparation and Rating. Method makeDrink() prepare coffee
// with typically components: {Water=100, Arabica=20}. Espresso and Cappuccino classes extends
// the Caffee Class and override method makeDrink(). Espresso caffee has 50 g. of Water.
// Cappuccino caffee has an additional of 50 g. of Milk.
//Create a averageRating() method of the MyUtils class to return a Map with coffee name
// as key and coffee average rating as value.
//For example, for a given list
//[Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10],
// Espresso [name=Espresso, rating=10], Cappuccino [name=Cappuccino, rating=6],
// Caffee [name=Caffee, rating=6]]
//you should get
//{Espresso=9.00, Cappuccino=8.00, Caffee=6.00}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

interface DrinkReceipt {
    String getName();
    DrinkReceipt addComponent(String componentName, int componentCount);
}
interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}
interface Rating {
    int getRating();
}
class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;
    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
    public String getName(){
        return name;
    }
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        return this;
    }
    public int getRating(){
        return rating;
    }
    public Map<String, Integer> makeDrink() {
        Map <String, Integer> map = new HashMap<>();
        map.put("Water", 100);
        map.put("Arabica", 20);
        return map;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Caffee coffee = (Caffee) o;
        return getName().equals(coffee.getName()) && rating == coffee.getRating();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName() == null ? 0 : getName().hashCode();
        result = prime * result + getRating();
        return result;
    }
}
class Espresso extends Caffee {
    public Espresso(String name, int rating) {
        super(name, rating);
    }
    @Override
    public Map<String, Integer> makeDrink() {
        Map <String, Integer> map = new HashMap<>();
        map.put("Water", 50);
        map.put("Arabica", 20);
        return map;
    }
}
class Cappuccino extends Caffee {
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }
    @Override
    public Map<String, Integer> makeDrink() {
        Map <String, Integer> map = new HashMap<>();
        map.put("Water", 100);
        map.put("Arabica", 20);
        map.put("Milk", 50);
        return map;
    }
}
public class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        Map<String, Double> result = new HashMap<>();
        Set<Espresso> espressoSet = new HashSet<>();
        Set<Cappuccino> cappuccinoSet = new HashSet<>();
        Set<Caffee> coffeeSet = new HashSet<>();
        int sumRatingEspresso = 0;
        int sumRatingCappuccino = 0;
        int sumRatingCoffee = 0;

        for(Caffee coffee : coffees) {
            if (coffee instanceof  Espresso) {
                espressoSet.add((Espresso) coffee);
                sumRatingEspresso += coffee.getRating();
            } else if (coffee instanceof Cappuccino) {
               cappuccinoSet.add((Cappuccino) coffee);
                sumRatingCappuccino += coffee.getRating();
            } else {
                coffeeSet.add(coffee);
                sumRatingCoffee += coffee.getRating();
            }
        }
        if(espressoSet.size() > 0) {
            result.put("Espresso", (double)sumRatingEspresso/espressoSet.size());
        }
        if(cappuccinoSet.size() > 0) {
            result.put("Cappuccino", (double)sumRatingCappuccino/cappuccinoSet.size());
        }
        if(coffeeSet.size() > 0) {
            result.put("Caffee", (double)sumRatingCoffee/coffeeSet.size());
        }
        return result;
    }
}
