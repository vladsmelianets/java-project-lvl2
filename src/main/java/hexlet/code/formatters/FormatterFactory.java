package hexlet.code.formatters;

public final class FormatterFactory {

    private FormatterFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static Formatter getFormatter(Format format) {
        return switch (format) {
            case STYLISH -> new StylishFormatter();
            case PLAIN -> new PlainFormatter();
            case JSON -> new JsonFormatter();
            default -> throw new IllegalArgumentException("Unsupported format type: " + format);
        };
    }
}
