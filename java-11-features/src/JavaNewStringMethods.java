public class JavaNewStringMethods {

    public static void main(String args[]) {
        String output = "La ".repeat(2) + "Land";
        System.out.println("output repreated " + output);
        String striped = "\n\t  hello   \u2005".strip();
        System.out.println(striped);
        System.out.println("\n\t  hello   \u2005".stripLeading());
        System.out.println("\n\t  hello   \u2005".stripTrailing());
        //Java 11 also added methods stripLeading() and stripTrailing(), which handle leading and trailing whitespaces, respectively.
        //the difference between trim and strip is that strip support unicode as well trim would identify \u2005 as a white space
        //The isBlank() instance method returns true if the string is empty or contains only whitespace. Otherwise, it returns false:
        System.out.println("\n\t\u2005  ".isBlank());
        System.out.println("\n\t\u2005  test".isBlank());

        String multilineStr = "This is\n \n a multiline\n string.";

         multilineStr.lines().forEach(System.out::println);

    }
}
