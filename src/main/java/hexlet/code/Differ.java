package hexlet.code;

import hexlet.code.formatters.FormatterFactory;
import hexlet.code.parsers.ParserFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class Differ {

    private Differ() {
        throw new IllegalStateException("Utility class");
    }

    public static String generate(String filepath1, String filepath2, String formatterName) throws IOException {
        String firstFileContent = Files.readString(Path.of(filepath1));
        String secondFileContent = Files.readString(Path.of(filepath2));

        Map<String, Object> firstProps = ParserFactory.getParser(filepath1).parseToMap(firstFileContent);
        Map<String, Object> secondProps = ParserFactory.getParser(filepath2).parseToMap(secondFileContent);

        Map<String, Map<ChangeStatus, Object>> differenceMap = getDifference(firstProps, secondProps);

        return FormatterFactory.getFormatter(formatterName).format(differenceMap);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }

    private static Map<String, Map<ChangeStatus, Object>> getDifference(Map<String, Object> firstProps,
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
