package hexlet.code.formatters;

import hexlet.code.ChangeStatus;

import java.util.Map;

final class PlainFormatter implements Formatter {

    @Override
    public String format(Map<String, Map<ChangeStatus, Object>> differenceMap) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Map<ChangeStatus, Object>> entry : differenceMap.entrySet()) {
            Map<ChangeStatus, Object> propChanges = entry.getValue();

            if (propChanges.containsKey(ChangeStatus.MODIFIED_FROM)
                    && propChanges.containsKey(ChangeStatus.MODIFIED_TO)) {
                String removed = formatValue(propChanges.get(ChangeStatus.MODIFIED_FROM));
                String added = formatValue(propChanges.get(ChangeStatus.MODIFIED_TO));
                result.append(String.format("Property '%s' was updated. From %s to %s%s",
                        entry.getKey(), removed, added, System.lineSeparator()));
            } else if (propChanges.containsKey(ChangeStatus.REMOVED)) {
                result.append(String.format("Property '%s' was removed%s", entry.getKey(), System.lineSeparator()));
            } else if (propChanges.containsKey(ChangeStatus.ADDED)) {
                String added = formatValue(propChanges.get(ChangeStatus.ADDED));
                result.append(String.format("Property '%s' was added with value: %s%s", entry.getKey(), added,
                        System.lineSeparator()));
            }
        }
        return result.toString().trim();
    }

    private String formatValue(Object value) {
        String result;
        if (value instanceof String && !value.equals("null")) {
            result = String.format("'%s'", value);
        } else {
            result = simplifyComplexValue(value);
        }
        return result;
    }

    private String simplifyComplexValue(Object value) {
        String stringValue = value.toString();
        if (stringValue.startsWith("[") || stringValue.startsWith("{")) {
            return "[complex value]";
        }
        return stringValue;
    }
}
