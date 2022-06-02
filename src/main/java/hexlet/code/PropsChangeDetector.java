package hexlet.code;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class PropsChangeDetector {

    public Map<String, String> compareProps(Map<String, String> firstProps, Map<String, String> secondProps) {
        Set<String> keys = new HashSet<>(firstProps.keySet());
        keys.addAll(secondProps.keySet());

        Map<String, String> difference = new TreeMap<>();
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
