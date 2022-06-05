package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public final class JsonParser implements Parser {

    private final ObjectMapper mapper;

    public JsonParser() {
        this.mapper = new ObjectMapper(new JsonFactory());
    }

    @Override
    public Map<String, Object> parseToMap(String json) throws JsonProcessingException {
        return mapper.readValue(json, Map.class);
    }
}
