package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

final class YamlParser implements Parser {

    private final ObjectMapper mapper;

    YamlParser() {
        this.mapper = new ObjectMapper(new YAMLFactory());
    }

    @Override
    public Map<String, Object> parseToMap(String yaml) throws JsonProcessingException {
        return mapper.readValue(yaml, Map.class);
    }
}
