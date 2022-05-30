package hexlet.code;

import picocli.CommandLine.Command;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.1",
        description = "Compares two configuration files and shows a difference.")
public final class Differ implements Runnable {

    public static void generate() {
        System.out.println("Placeholder for Differ.generate");
    }

    @Override
    public void run() {

    }
}
