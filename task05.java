//Create a Stream<Integer> duplicateElements(Stream<Integer> stream) method of the MyUtils class
//to return a sorted stream of duplicated elements of the input stream.
//For example, for a given elements
//[3, 2, 1, 1, 12, 3, 8, 2, 4, 2]
//you should get
//[1, 2, 3]


import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map;

public class MyUtils {
   public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        return stream.filter(n -> n != null).collect(Collectors.groupingBy(Function.identity()
                , Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).sorted();
    }
}
