package hexlet.code.formatters;

import hexlet.code.ChangeStatus;

import java.io.IOException;
import java.util.Map;

public interface Formatter {
    String format(Map<String, Map<ChangeStatus, Object>> differenceMap) throws IOException;
}
