package hexlet.code.formatters;

import hexlet.code.Change;

import java.util.Map;

final class StylishFormatter implements Formatter {

    @Override
    public String format(Map<String, Change> differenceMap) {
        StringBuilder result = new StringBuilder("{" + System.lineSeparator());
        for (Map.Entry<String, Change> entry : differenceMap.entrySet()) {
            String property = entry.getKey();
            Change change = entry.getValue();
            Change.Status status = change.getStatus();
            switch (status) {
                case UNCHANGED -> result.append(String.format("    %s: %s", property, change.getOldValue()))
                        .append(System.lineSeparator());
                case DELETED -> result.append(String.format("  - %s: %s", property, change.getOldValue()))
                        .append(System.lineSeparator());
                case ADDED -> result.append(String.format("  + %s: %s", property, change.getNewValue()))
                        .append(System.lineSeparator());
                case CHANGED -> result.append(String.format("  - %s: %s", property, change.getOldValue()))
                        .append(System.lineSeparator())
                        .append(String.format("  + %s: %s", property, change.getNewValue()))
                        .append(System.lineSeparator());
                default -> throw new IllegalStateException("Unknown status: " + status);
            }
        }
        return result.append("}").toString();
    }
}
