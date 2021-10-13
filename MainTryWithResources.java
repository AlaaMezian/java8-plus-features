import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MainTryWithResources {
    public static void main(String args[]) throws FileNotFoundException {
        //Java 7 version need you to instantiate the resource with in the try in order for the try catch to work
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        //java 9 version allows you to instantiate the resource outside the try and still automatically close the resource
        final FileOutputStream fileStream = new FileOutputStream("javatpoint.txt");
        try (fileStream) {
            String greeting = "Welcome to Java.";
            byte b[] = greeting.getBytes();
            fileStream.write(b);
            System.out.println("File written");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
