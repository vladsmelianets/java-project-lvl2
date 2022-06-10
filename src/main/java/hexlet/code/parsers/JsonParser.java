package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

final class JsonParser implements Parser {

    private final ObjectMapper mapper;

    JsonParser() {
        this.mapper = new ObjectMapper(new JsonFactory());
    }

    @Override
    public Map<String, Object> parseToMap(String json) throws JsonProcessingException {
        return mapper.readValue(json, Map.class);
    }
}
