package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

public final class PropertiesFileReader {

    private PropertiesFileReader() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, String> readPropsFile(String filename) throws IOException {

        Map<String, String> result;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(filename))) {
            result = bufferedReader.lines()
                    .filter(line -> !line.contains("{") && !line.contains("}"))
                    .map(line -> line.replace("\"", ""))
                    .collect(Collectors.toMap(
                            line -> line.substring(0, line.indexOf(":")).trim(),
                            line -> line.substring(line.indexOf(":") + 1).trim()
                    ));
        }
        return result;
    }
}
