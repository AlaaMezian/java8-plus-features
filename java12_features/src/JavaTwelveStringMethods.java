package java12

public class JavaTwelveStringMethods {

    public static void main(String args[]){
        String text = "Hello Mezian!\nThis is Java 12 article.";

        //indent can be used to add indent(spaces) at the start of a string or remove spaces from a string
        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);

        //the other new method is transform this one can be used on a string to apply transformation function on it for example reverse a string
        String stringToReverse = "Mezian";
        String transformed = stringToReverse.transform(value ->
                new StringBuilder(value).reverse().toString()
        );

    }
}
