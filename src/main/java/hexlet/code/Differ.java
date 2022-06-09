package hexlet.code;

import hexlet.code.formatters.FormatterFactory;
import hexlet.code.parsers.ParserFactory;
import hexlet.code.utils.FileHelper;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class Differ {

    private Differ() {
        throw new IllegalStateException("Utility class");
    }

    public static String generate(String filepath1, String filepath2, String formatterName) throws IOException {
        String firstFileContent = FileHelper.readToString(filepath1);
        String secondFileContent = FileHelper.readToString(filepath2);

        Map<String, Object> firstProps = ParserFactory.getParser(filepath1).parseToMap(firstFileContent);
        Map<String, Object> secondProps = ParserFactory.getParser(filepath2).parseToMap(secondFileContent);

        Map<String, Map<ChangeStatus, Object>> differenceMap = getDifference(firstProps, secondProps);

        return FormatterFactory.getFormatter(formatterName).format(differenceMap);
    }

    private static Map<String, Map<ChangeStatus, Object>> getDifference(Map<String, Object> firstProps,
            Map<String, Object> secondProps) {

        Set<String> keys = new TreeSet<>(firstProps.keySet());
        keys.addAll(secondProps.keySet());

        Map<String, Map<ChangeStatus, Object>> difference = new LinkedHashMap<>();
        for (String key : keys) {
            Object firstVal = ifNullThenToNullLiteral(firstProps.get(key));
            Object secondVal = ifNullThenToNullLiteral(secondProps.get(key));
            if (!secondProps.containsKey(key)) {
                difference.put(key, Map.of(ChangeStatus.REMOVED, firstVal));
            } else if (!firstProps.containsKey(key)) {
                difference.put(key, Map.of(ChangeStatus.ADDED, secondVal));
            } else if (firstVal.equals(secondVal)) {
                difference.put(key, Map.of(ChangeStatus.NOT_MODIFIED, firstVal));
            } else {
                difference.put(key, Map.of(
                        ChangeStatus.REMOVED, firstVal,
                        ChangeStatus.ADDED, secondVal));
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
