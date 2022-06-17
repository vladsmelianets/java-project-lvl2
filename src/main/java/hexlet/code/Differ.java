package hexlet.code;

import hexlet.code.formatters.FormatterFactory;
import hexlet.code.parsers.ParserFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public final class Differ {

    private Differ() {
        throw new IllegalStateException("Utility class");
    }

    public static String generate(String filepath1, String filepath2, String formatterName) throws IOException {
        String firstFileContent = Files.readString(Path.of(filepath1));
        String secondFileContent = Files.readString(Path.of(filepath2));

        Map<String, Object> firstProps = ParserFactory.getParser(getFileType(filepath1)).parseToMap(firstFileContent);
        Map<String, Object> secondProps = ParserFactory.getParser(getFileType(filepath2)).parseToMap(secondFileContent);

        Map<String, Change> difference = MapDifference.getDifference(firstProps, secondProps);

        return FormatterFactory.getFormatter(formatterName).format(difference);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String getFileType(String filepath) {
        String[] strings = filepath.split("\\.");
        return strings[strings.length - 1];
    }
}
