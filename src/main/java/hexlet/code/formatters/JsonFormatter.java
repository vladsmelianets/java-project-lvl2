package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Change;

import java.io.IOException;
import java.util.Map;

final class JsonFormatter implements Formatter {

    @Override
    public String format(Map<String, Change> differenceMap) throws IOException {
        return new ObjectMapper().writeValueAsString(differenceMap);
    }
}
