package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.1",
        description = "Compares two configuration files and shows a difference.")
public final class Differ implements Runnable {

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String firstFilePath;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String secondFilePath;

    public static String generate(String firstFilePath, String secondFilePath) {
        return "Placeholder for Differ.generate";
    }

    public static Map<String, String> compareProps(Map<String, String> firstProps, Map<String, String> secondProps) {
        Set<String> keys = new LinkedHashSet<>(firstProps.keySet());
        keys.addAll(secondProps.keySet());

        Map<String, String> difference = new LinkedHashMap<>();
        for (String key : keys) {
            if (!secondProps.containsKey(key)) {
                difference.put(key + ": " + firstProps.get(key), "-");
            } else if (!firstProps.containsKey(key)) {
                difference.put(key + ": " + secondProps.get(key), "+");
            } else if (firstProps.get(key).equals(secondProps.get(key))) {
                difference.put(key + ": " + firstProps.get(key), "");
            } else {
                difference.put(key + ": " + firstProps.get(key), "-");
                difference.put(key + ": " + secondProps.get(key), "+");
            }
        }
        return difference;
    }

    @Override
    public void run() {

    }
}
