package java12_features.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMissMatchMethod {
    public static void main(String args[]) throws IOException {
        givenIdenticalFiles_thenShouldNotFindMismatch();
        givenDifferentFiles_thenShouldFindMismatch();

    }

    private static void givenIdenticalFiles_thenShouldNotFindMismatch() throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        long mismatch = Files.mismatch(filePath1, filePath2);
        //this return -1 the files identical in content
    }

    private static void givenDifferentFiles_thenShouldFindMismatch() throws IOException {
        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3, "Java 12 Article");
        Files.writeString(filePath4, "Java 12 Tutorial");

        long mismatch = Files.mismatch(filePath3, filePath4);
        //this return a value other than -1 means the two files are not the same the value returned present the byte position for missmatch string
    }

}

