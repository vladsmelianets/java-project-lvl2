package hexlet.code.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class PropsUtils {

    private PropsUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, String> getDifference(Map<String, Object> firstProps, Map<String, Object> secondProps) {
        Set<String> keys = new TreeSet<>(firstProps.keySet());
        keys.addAll(secondProps.keySet());

        Map<String, String> difference = new LinkedHashMap<>();
        for (String key : keys) {
            if (!secondProps.containsKey(key)) {
                difference.put(key + ": " + firstProps.get(key), "-");
            } else if (!firstProps.containsKey(key)) {
                difference.put(key + ": " + secondProps.get(key), "+");
            } else if (firstProps.get(key).equals(secondProps.get(key))) {
                difference.put(key + ": " + firstProps.get(key), " ");
            } else {
                difference.put(key + ": " + firstProps.get(key), "-");
                difference.put(key + ": " + secondProps.get(key), "+");
            }
        }
        return difference;
    }
}
