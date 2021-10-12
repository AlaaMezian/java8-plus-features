package java-9-interface-private-feature;
public interface InterfaceDefaultPrivate {

    private static String staticPrivate() {
        return "static private";
    }

    private String instancePrivate() {
        return "instance private";
    }


    default void interfaceMethodWithDefault() {
        System.out.println("default method behaviour 1");
        String result = instancePrivate();
        System.out.println("private method behaviour " + result);
    }

    default void anotherDefaultMethod() {
        System.out.println("default method behaviour 2");
        String result = instancePrivate();
        System.out.println("private method behaviour " + result);
    }

    default void anotherDefaultMethodStaticPrivate() {
        System.out.println("default method behaviour 3");
        String result = staticPrivate();
        System.out.println("private method behaviour " + result);
    }

}
