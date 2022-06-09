package hexlet.code.parsers;

public final class ParserFactory {

    private ParserFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static Parser getParser(String filename) {
        if (filename.contains(".yml")) {
            return new YamlParser();
        }
        if (filename.contains(".json")) {
            return new JsonParser();
        }
        throw new IllegalArgumentException("Unsupported file format: " + filename);
    }
}
