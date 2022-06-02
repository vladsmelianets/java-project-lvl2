package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

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

    @Override
    public void run() {

    }
}
