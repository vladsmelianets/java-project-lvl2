package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//TODO consider change name or move all to Differ
public final class PropsChangeDetector {

    public Map<String, Object> compareProps(Map<String, Object> firstProps, Map<String, Object> secondProps) {
        Set<String> keys = new TreeSet<>(firstProps.keySet());
        keys.addAll(secondProps.keySet());

        Map<String, Object> difference = new LinkedHashMap<>();
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
