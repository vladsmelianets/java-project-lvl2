package hexlet.code;

import hexlet.code.parsers.ParserFactory;
import hexlet.code.utils.FileUtils;
import hexlet.code.utils.PropsUtils;

import java.io.IOException;
import java.util.Map;

public final class Differ {

    private Differ() {
        throw new IllegalStateException("Utility class");
    }

    public static String generate(String firstFilePath, String secondFilePath) throws IOException {
        Map<String, Object> firstProps = ParserFactory.getParser(firstFilePath)
                .parseToMap(FileUtils.readToString(firstFilePath));
        Map<String, Object> secondProps = ParserFactory.getParser(secondFilePath)
                .parseToMap(FileUtils.readToString(secondFilePath));

        Map<String, Object> differenceMap = PropsUtils.getDifference(firstProps, secondProps);

        StringBuilder result = new StringBuilder();
        differenceMap.forEach((key, val) -> result.append(val).append(" ").append(key).append("\n"));

        return result.toString();
    }
}
