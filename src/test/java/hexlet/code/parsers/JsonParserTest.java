package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class JsonParserTest {

    private final JsonParser parser = new JsonParser();

    @Test
    @DisplayName("Should return prop map with Lists as nested values when given nested Json string")
    void shouldReturnPropMapWhenGivenNestedJsonString() throws JsonProcessingException, URISyntaxException {
        String json = Files.contentOf(new File(getClass().getClassLoader().getResource("nested-json-fixture-1.json")
                .toURI()), "UTF-8");

        Map<String, Object> expected = new LinkedHashMap<>();
        expected.put("setting1", "Some value");
        expected.put("setting2", 200);
        expected.put("setting3", true);
        expected.put("key1", "value1");
        expected.put("numbers1", Arrays.asList(1, 2, 3, 4));
        expected.put("numbers2", Arrays.asList(2, 3, 4, 5));
        expected.put("id", 45);
        expected.put("default", null);
        expected.put("checked", false);
        expected.put("numbers3", Arrays.asList(3, 4, 5));
        expected.put("chars1", Arrays.asList("a", "b", "c"));
        expected.put("chars2", Arrays.asList("d", "e", "f"));

        Assertions.assertThat(parser.parseToMap(json)).isEqualTo(expected);
    }
}
