import java.security.Key;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class Main {
    public static void main(String[] args) {
        String words = "арбуз баба вага вага гага арбуз";
        System.out.println("TOP 10:");
        Arrays.stream(words.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(comparingByKey()))
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + "-" + e.getValue()));


    }
}