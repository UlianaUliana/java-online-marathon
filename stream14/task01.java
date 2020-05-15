//Let the key of Map is project name and value contains list of participants.
//Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class
// to build sorted stream of all participants without duplication.
//Please ignore null or empty strings, extra spaces and case sensitivity.
//Throw NullPointerException if map is null.
//For example, for a given map
//{"Desktop"=[" iVan", "PeTro ", " Ira "],
// "Web"=["STepan", "ira ", " Andriy ", "an na"],
// "Spring"=["Ivan", "Anna"]}
//you should get
//["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]


import java.util.Map;
import java.util.stream.Stream;

public class MyUtils {
   public Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        Stream<String> newStream = Stream.of("");
        for (Stream<String> stream : map.values()) {
            if (stream != null) {
                newStream = Stream.concat(newStream, stream);
            }
        }
        return newStream.filter(el-> el != null && !el.trim().isEmpty())
            .map(el -> el.replaceAll("\\s",""))
            .map(el -> {return Character.toUpperCase(el.charAt(0)) + el.toLowerCase().substring(1);})
            .distinct()
            .sorted();
    }
}
