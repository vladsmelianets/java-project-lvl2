package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

public interface Parser {
    Map<String, String> parseToMap(String json) throws JsonProcessingException;
}
