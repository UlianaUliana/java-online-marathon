//Create a int countNumbers(IntStream intNum, Stream<String> strNum) method of the MyUtils class
// to count of numbers that is divisible by 3 or contains the digit 3.
//The parameters of the method are two Streams with integers and Strings with one number.
//For example, for a given
//[[3, 2, 1, 13, 21, 15], ["9", "4", "23", "0", "32", "5"]]
//you should get 7



import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyUtils {
   public long countNumbers(IntStream intNum, Stream<String> strNum) {
        return Stream.concat(intNum.boxed(), strNum.filter(s -> s != null && !s.trim().isEmpty()).map(s -> Integer.valueOf(s)))
                .filter(i -> i != 0)
                .filter(i -> i % 3 == 0 || i % 10 == 3 || i /10 == 3 || i % 10 == -3 || i /10 == -3)
                 .count();
    }
}
