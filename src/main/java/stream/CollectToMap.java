package stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectToMap {
    public static void main(String args[]) {


        final Map<String, Integer> wordCounts = new HashMap<>();
        wordCounts.put("USA", 100);
        wordCounts.put("jobs", 200);
        wordCounts.put("software", 50);
        wordCounts.put("technology", 70);
        wordCounts.put("opportunity", 200);
        wordCounts.put("USA", 400);// Remember we can only have one element by key

        List<String> listWords = Arrays.asList("Software", "USA", "Positions", "java", "Sofwares");

        System.out.println("listWords");
        System.out.println(listWords);

        wordCounts.entrySet().stream()
                .map(stringIntegerEntry -> stringIntegerEntry.getValue())
                .count();


        Map<String, Long> firstMapUsingKeyValueMapper = wordCounts.entrySet().stream()
                .collect(Collectors.toMap(s -> s.getKey(), stringIntegerEntry -> stringIntegerEntry.getValue().longValue() * 4));


        Map<Character, String> firstMapUsingBinaryMerged = listWords.stream()
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s, (first, last) -> first));

   /* Having problem with using key + Function.identity when the stream is a Map
    Map<String, Integer> collect = wordCounts.entrySet().stream()
            .collect(Collectors.toMap(s -> s.getKey(),Function.identity()));
*/

        LinkedHashMap<Character, String> firstMapUsingMapSupplier = listWords.stream()
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s, (first, last) -> first, LinkedHashMap::new));

        System.out.println(firstMapUsingMapSupplier);

    }
}
