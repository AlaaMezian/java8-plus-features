import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeveloperFeatures {

    public static void main(String args[]) throws IOException {
        collectionToArray();
        readStringWriteString();
        theNotPredict();
    }


    private static void collectionToArray() {
        List books = Arrays.asList("the psychology of money", "the 5 am club", "the 7 habits of highly effective people");
        String[] booksArray = (String[]) books.toArray(String[]::new);
        Stream.of(booksArray).forEach(System.out::print);
    }

    private static void readStringWriteString() throws IOException {
        Path tempDir = null;
        Path filePath = Files.writeString(Files.createTempFile(tempDir, "demo", ".txt"), "Sample text");
        String fileContent = Files.readString(filePath);
    }

    private static void theNotPredict(){
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        Stream.of(withoutBlanks).forEach(System.out::print);

    }
}
