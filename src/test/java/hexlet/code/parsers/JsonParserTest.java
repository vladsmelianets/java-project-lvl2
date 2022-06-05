package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class JsonParserTest {

    private final JsonParser parser = new JsonParser();

    @Test
    void parseToMap() throws JsonProcessingException {
        String json = "{\n  \"testPropName\": \"testValue\"\n}";
        Map<String, String> expected = Map.of("testPropName", "testValue");

        Assertions.assertThat(parser.parseToMap(json)).isEqualTo(expected);
    }
}
