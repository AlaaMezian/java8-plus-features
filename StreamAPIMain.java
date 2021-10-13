import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIMain {
    public static void main(String args[]) {
        //Stream takeWhile method takes each element that matches its predicate. It stops when it get unmatched element.
        // It returns a subset of elements that contains all matched elements, other part of stream is discarded.
        List<Integer> list
                = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .takeWhile(i -> (i % 2 == 0)).collect(Collectors.toList());
        System.out.println(list);

        List<Integer> list2
                = Stream.of(2, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .takeWhile(i -> (i % 2 == 0)).collect(Collectors.toList());
        System.out.println(list2);

        // dropWhile() It stops when it get unmatched element
        // Ordered stream: It returns a stream that contains elements after dropping the elements that match the given predicate.
        // Unordered stream: It returns a stream that contains remaining elements of this stream after dropping a subset of elements that match the given predicate.
        List<Integer> listDropWhile
                = Stream.of(2, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .dropWhile(i -> (i % 2 == 0)).collect(Collectors.toList());
        System.out.println(listDropWhile);

        //Stream of nullable
        Stream<Integer> val
                = Stream.ofNullable(null);
        val.forEach(System.out::println);

        //A new overloaded method iterate is added to the Java 9 stream interface. This method allows us to iterate stream elements till the specified condition
        Stream.iterate(1, i -> i <= 10, i -> i * 3)
                .forEach(System.out::println);
    }
}
