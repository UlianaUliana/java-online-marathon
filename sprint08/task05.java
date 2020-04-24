/Please, implement a static method getPredicateFromSet in MyUtils class.
//
//getPredicateFromSet should take a Set of predicates working with integers as a parameter
// and return a predicate with the functionality of all predicates in the set invoked
// and connected by logical AND.

import java.util.function.Predicate;
import java.util.Set;

class MyUtils{
   static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicateSet){
        Predicate<Integer> resultPredicate = value -> {
            boolean result = true;
            for (Predicate<Integer> predicate : predicateSet) {
                result = result && predicate.test(value);
            }
            return result;
        };
        return resultPredicate;
    }
}
