package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class MapDifference {

    private MapDifference() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Map<ChangeStatus, Object>> getDifference(Map<String, Object> firstProps,
            Map<String, Object> secondProps) {

        Set<String> keys = new TreeSet<>(firstProps.keySet());
        keys.addAll(secondProps.keySet());

        Map<String, Map<ChangeStatus, Object>> difference = new LinkedHashMap<>();
        for (String key : keys) {
            Object firstVal = ifNullThenToNullLiteral(firstProps.get(key));
            Object secondVal = ifNullThenToNullLiteral(secondProps.get(key));
            Map<ChangeStatus, Object> changes = new LinkedHashMap<>();
            if (!secondProps.containsKey(key)) {
                changes.put(ChangeStatus.REMOVED, firstVal);
                difference.put(key, changes);
            } else if (!firstProps.containsKey(key)) {
                changes.put(ChangeStatus.ADDED, secondVal);
                difference.put(key, changes);
            } else if (firstVal.equals(secondVal)) {
                changes.put(ChangeStatus.NOT_MODIFIED, firstVal);
                difference.put(key, changes);
            } else {
                changes.put(ChangeStatus.REMOVED, firstVal);
                changes.put(ChangeStatus.ADDED, secondVal);
                difference.put(key, changes);
            }
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
