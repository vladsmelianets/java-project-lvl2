package hexlet.code.formatters;

public final class FormatterFactory {

    private FormatterFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static Formatter getFormatter(String formatName) {
        if (formatName.equals("stylish")) {
            return new StylishFormatter();
        }
        if (formatName.equals("plain")) {
            return new PlainFormatter();
        }
        if (formatName.equals("json")) {
            return new JsonFormatter();
        }
        throw new IllegalArgumentException("Unsupported format type: " + formatName);
    }
}
