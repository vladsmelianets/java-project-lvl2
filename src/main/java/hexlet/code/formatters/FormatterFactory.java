package hexlet.code.formatters;

public final class FormatterFactory {

    private FormatterFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static Formatter getFormatter(String format) {
        return switch (format) {
            case "stylish" -> new StylishFormatter();
            case "plain" -> new PlainFormatter();
            case "json" -> new JsonFormatter();
            default -> throw new IllegalArgumentException("Unsupported format type: " + format);
        };
    }
}
