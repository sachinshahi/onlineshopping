package blog;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream<String> streamEmpty = Stream.empty();
        System.out.println(streamEmpty);

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamCollection = collection.stream();
        System.out.println(streamCollection);

        Stream<String> streamOfArray = Stream.of("a", "b", "c");
        System.out.println(streamOfArray);

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stramOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
    }
}
