package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.ChangeStatus;

import java.io.IOException;
import java.util.Map;

public final class JsonFormatter implements Formatter {

    @Override
    public String format(Map<String, Map<ChangeStatus, Object>> differenceMap) throws IOException {
        return new ObjectMapper().writeValueAsString(differenceMap);
    }
}
