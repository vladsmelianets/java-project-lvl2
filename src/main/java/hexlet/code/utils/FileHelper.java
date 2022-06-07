package hexlet.code.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileHelper {

    private FileHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static String readToString(String filename) throws IOException {
        StringBuilder resultBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(filename))) {
            bufferedReader.lines().forEach(line -> resultBuilder.append(line).append("\n"));
            return resultBuilder.toString().trim();
        }
    }
}
