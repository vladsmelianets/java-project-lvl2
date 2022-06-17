package hexlet.code.parsers;

public final class ParserFactory {

    private ParserFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static Parser getParser(String fileType) {
        return switch (fileType) {
            case "yml", "yaml" -> new YamlParser();
            case "json" -> new JsonParser();
            default -> throw new IllegalArgumentException("Unsupported file format: " + fileType);
        };
    }
}
