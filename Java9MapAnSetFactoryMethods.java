import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class Java9MapAnSetFactoryMethods {

    private Map<String, String> map;

    public static void main(String args[]) {
        initializeMap();
        initializeSet();
    }

    private static Map<String, String> initializeMap() {
        Map<String, String> emptyMap = Map.of();
        Map<String, String> singletonMap = Map.of("key1", "value");
        Map<String, String> map = Map.of("key1", "value1", "key2", "value2");
        Map<String, String> mapOfEntries = Map.ofEntries(
                new AbstractMap.SimpleEntry<String, String>("name", "John"),
                new AbstractMap.SimpleEntry<String, String>("city", "budapest"),
                new AbstractMap.SimpleEntry<String, String>("zip", "000000"),
                new AbstractMap.SimpleEntry<String, String>("home", "1231231231")
        );
        return map;
    }

    private static Set<String> initializeSet() {
        Set<String> strKeySet = Set.of("key1", "key2", "key3");
        return strKeySet;
    }
}
