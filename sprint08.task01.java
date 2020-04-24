//Please, implement a static method getCount that takes an array of integers
// as the first parameter. The second parameter - a functional interface that works
// with integers and defines a condition.
//
//The method should return the count of elements in the array that satisfy the condition
// defined by the second argument.

import java.util.Arrays;
import java.util.function.Predicate;
public class MyUtils {
    public static int getCount(int[] arr, Predicate<Integer> p) {
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (p.test(arr[i])) {
                count++;
            }
        }
        return count;
    }
}
