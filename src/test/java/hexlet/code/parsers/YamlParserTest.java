package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

class YamlParserTest {

    private static final int TIMEOUT_VAL = 50; // to satisfy linter's paranoia
    private final YamlParser parser = new YamlParser();

    @Test
    void parseToMap() throws JsonProcessingException {
        String yaml = """
                follow: false
                host: hexlet.io
                proxy: 123.234.53.22
                timeout: 50""";

        Map<String, Object> expected = Map.of(
                "follow", false,
                "host", "hexlet.io",
                "proxy", "123.234.53.22",
                "timeout", TIMEOUT_VAL);

        Assertions.assertThat(parser.parseToMap(yaml)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return prop map with Lists as nested values when given nested Yaml string")
    void shouldReturnPropMapWhenGivenNestedJsonString() throws JsonProcessingException {
        String yaml = "{\n\"key1\": \"value1\",\n\"numbers1\": [1, 2, 3, 4]\n}";
        Map<String, Object> expected = Map.of("key1", "value1", "numbers1", Arrays.asList(1, 2, 3, 4));

        Assertions.assertThat(parser.parseToMap(yaml)).isEqualTo(expected);
    }
}
