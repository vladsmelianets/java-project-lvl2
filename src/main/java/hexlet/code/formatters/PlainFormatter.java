package hexlet.code.formatters;

import hexlet.code.Change;

import java.util.Map;

final class PlainFormatter implements Formatter {

    @Override
    public String format(Map<String, Change> differenceMap) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Change> entry : differenceMap.entrySet()) {
            String property = entry.getKey();
            Change change = entry.getValue();
            Change.Status status = change.getStatus();
            switch (status) {
                case DELETED ->
                        result.append(String.format("Property '%s' was removed%s", property, System.lineSeparator()));
                case ADDED -> result.append(String.format("Property '%s' was added with value: %s", property,
                                formatValue(change.getNewValue())))
                        .append(System.lineSeparator());
                case CHANGED -> result.append(String.format("Property '%s' was updated. From %s to %s",
                                property, formatValue(change.getOldValue()), formatValue(change.getNewValue())))
                        .append(System.lineSeparator());
                default -> {
                    if (!status.equals(Change.Status.UNCHANGED)) {
                        throw new IllegalStateException("Unknown status: " + status);
                    }
                }
            }
        }
        return result.toString().trim();
    }

    private String formatValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return String.format("'%s'", value);
        } else {
            return simplifyComplexValue(value);
        }
    }

    private String simplifyComplexValue(Object value) {
        String stringValue = value.toString();
        if (stringValue.startsWith("[") || stringValue.startsWith("{")) {
            return "[complex value]";
        }
        return stringValue;
    }
}
