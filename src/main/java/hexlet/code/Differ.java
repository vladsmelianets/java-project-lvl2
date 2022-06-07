package hexlet.code;

import hexlet.code.parsers.ParserFactory;
import hexlet.code.utils.FileHelper;
import hexlet.code.utils.PropsUtils;

import java.io.IOException;
import java.util.Map;

public final class Differ {

    private Differ() {
        throw new IllegalStateException("Utility class");
    }

    public static String generate(String firstFilePath, String secondFilePath) throws IOException {
        Map<String, Object> firstProps = ParserFactory.getParser(firstFilePath)
                .parseToMap(FileHelper.readToString(firstFilePath));
        Map<String, Object> secondProps = ParserFactory.getParser(secondFilePath)
                .parseToMap(FileHelper.readToString(secondFilePath));

        Map<String, String> differenceMap = PropsUtils.getDifference(firstProps, secondProps);

        StringBuilder result = new StylishFormatter().format(differenceMap);

        return result.toString();
    }
}
