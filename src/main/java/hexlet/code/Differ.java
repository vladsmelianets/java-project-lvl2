package hexlet.code;

import hexlet.code.formatters.FormatterFactory;
import hexlet.code.parsers.ParserFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static hexlet.code.MapCompareUtils.getDifference;

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
}
