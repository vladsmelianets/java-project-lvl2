package hexlet.code;

import java.util.Map;

public final class StylishFormatter {

    public StringBuilder format(Map<String, String> differenceMap) {
        StringBuilder result = new StringBuilder();
        differenceMap.forEach((key, val) -> result.append(val).append(" ").append(key).append("\n"));
        return result;
    }
}
