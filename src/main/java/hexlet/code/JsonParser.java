package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonParser {

    private final ObjectMapper mapper;

    public JsonParser() {
        this.mapper = new ObjectMapper();
    }

    public Map<String, String> toMap(String json) throws JsonProcessingException {
        return mapper.readValue(json, Map.class);
    }
}
