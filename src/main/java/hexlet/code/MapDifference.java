package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class MapDifference {

    private MapDifference() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Change> getDifference(Map<String, Object> firstProps, Map<String, Object> secondProps) {

        Set<String> keys = new TreeSet<>(firstProps.keySet());
        keys.addAll(secondProps.keySet());

        Map<String, Change> difference = new LinkedHashMap<>();
        for (String key : keys) {
            Object firstVal = ifNullThenToNullLiteral(firstProps.get(key));
            Object secondVal = ifNullThenToNullLiteral(secondProps.get(key));
            Change change;
            if (!secondProps.containsKey(key)) {
                change = Change.builder()
                        .status(Change.Status.DELETED)
                        .oldValue(firstVal)
                        .build();
            } else if (!firstProps.containsKey(key)) {
                change = Change.builder()
                        .status(Change.Status.ADDED)
                        .newValue(secondVal)
                        .build();
            } else if (firstVal.equals(secondVal)) {
                change = Change.builder()
                        .status(Change.Status.UNCHANGED)
                        .oldValue(firstVal)
                        .build();
            } else {
                change = Change.builder()
                        .status(Change.Status.CHANGED)
                        .oldValue(firstVal)
                        .newValue(secondVal)
                        .build();
            }
            difference.put(key, change);
        }
        return difference;
    }

    private static Object ifNullThenToNullLiteral(Object obj) {
        if (obj == null) {
            obj = "null";
        }
        return obj;
    }
}
