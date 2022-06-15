package hexlet.code.formatters;

import hexlet.code.Change;

import java.io.IOException;
import java.util.Map;

public interface Formatter {
    String format(Map<String, Change> differenceMap) throws IOException;
}
