package hexlet.code.formatters;

import hexlet.code.ChangeStatus;

import java.util.Map;

final class StylishFormatter implements Formatter {

    @Override
    public String format(Map<String, Map<ChangeStatus, Object>> differenceMap) {
        StringBuilder result = new StringBuilder("{" + System.lineSeparator());
        for (Map.Entry<String, Map<ChangeStatus, Object>> entry : differenceMap.entrySet()) {
            Map<ChangeStatus, Object> propChanges = entry.getValue();

            if (propChanges.containsKey(ChangeStatus.NOT_MODIFIED)) {
                result.append(String.format("    %s: %s", entry.getKey(), propChanges.get(ChangeStatus.NOT_MODIFIED)))
                        .append(System.lineSeparator());
            }
            if (propChanges.containsKey(ChangeStatus.REMOVED)) {
                result.append(String.format("  - %s: %s", entry.getKey(), propChanges.get(ChangeStatus.REMOVED)))
                        .append(System.lineSeparator());
            }
            if (propChanges.containsKey(ChangeStatus.ADDED)) {
                result.append(String.format("  + %s: %s", entry.getKey(), propChanges.get(ChangeStatus.ADDED)))
                        .append(System.lineSeparator());
            }
        }
        return result.append("}").toString();
    }
}
