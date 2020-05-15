//Create a int sumEven(Stream<IntStream> stream) method of the MyUtils class to sum minimal positive even numbers from all Streams.
//Return zero if minimum positive even element was not found in stream.
//For example, for a given
//[[-2, -4, 1, 8, 3, 10], [2, -4, 4, 0, 3, 1], [1, -4, 3, 5, 3, 1]]
//you should get 10 (8+2+0)


import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyUtils {
   public int sumEven(Stream<IntStream> stream) {
        return stream.map(str -> str.filter(i -> i > 0)
                .filter(i -> i % 2 == 0)
                .min()
                .orElse(0))
                .reduce(0, (sum, p) -> sum = sum + p);
    }
}
