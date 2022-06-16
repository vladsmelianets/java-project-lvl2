package hexlet.code.parsers;

public final class ParserFactory {

    private ParserFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static Parser getParser(FileType fileType) {
        return switch (fileType) {
            case YAML -> new YamlParser();
            case JSON -> new JsonParser();
            default -> throw new IllegalArgumentException("Unsupported file format: " + fileType);
        };
    }
}
