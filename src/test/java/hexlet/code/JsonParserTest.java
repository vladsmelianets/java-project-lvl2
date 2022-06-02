package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.parsers.JsonParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class JsonParserTest {

    private final JsonParser parser = new JsonParser();

    @Test
    void toMap() throws JsonProcessingException {
        String json = "{\n  \"testPropName\": \"testValue\"\n}";
        Map<String, String> expected = Map.of("testPropName", "testValue");

        Assertions.assertThat(parser.parseToMap(json)).isEqualTo(expected);
    }
}
