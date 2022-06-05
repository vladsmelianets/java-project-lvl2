package hexlet.code;

import hexlet.code.parsers.JsonParser;

import java.io.IOException;
import java.util.Map;

public final class Differ {

    private Differ() {
        throw new IllegalStateException("Utility class");
    }

    public static String generate(String firstFilePath, String secondFilePath) throws IOException {
        JsonParser parser = new JsonParser();

        Map<String, Object> firstProps = parser.parseToMap(FileReader.readToString(firstFilePath));
        Map<String, Object> secondProps = parser.parseToMap(FileReader.readToString(secondFilePath));



        PropsChangeDetector changeDetector = new PropsChangeDetector();
        Map<String, Object> differenceMap = changeDetector.compareProps(firstProps, secondProps);

        StringBuilder builder = new StringBuilder();
        differenceMap.forEach((key, val) -> builder.append(val).append(" ").append(key).append("\n"));

        return builder.toString();
    }
}
