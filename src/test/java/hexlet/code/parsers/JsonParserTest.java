package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Files;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class JsonParserTest {

    private final JsonParser parser = new JsonParser();

    private static String jsonWithNestedList;
    private static String jsonWithNestedMap;

    @BeforeAll
    static void setupFixtures() throws URISyntaxException {
        jsonWithNestedList = Files.contentOf(
                new File(YamlParserTest.class.getClassLoader().getResource("nested-json-fixture-1.yaml").toURI()),
                "UTF-8");
        jsonWithNestedMap = Files.contentOf(
                new File(YamlParserTest.class.getClassLoader().getResource("nested-json-fixture-2.yaml").toURI()),
                "UTF-8");
    }

    @Test
    @DisplayName("Should return prop map with lists when given Json with nested lists")
    void shouldReturnPropMapWhenGivenJsonWithNestedLists() throws JsonProcessingException {
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

        Assertions.assertThat(parser.parseToMap(jsonWithNestedList)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return prop map with maps when given Json with nested maps")
    void shouldReturnPropMapWhenGivenJsonWithNestedMaps() throws JsonProcessingException {
        Map<String, Object> expected = new LinkedHashMap<>();
        expected.put("setting1", "Another value");
        expected.put("setting2", 300);
        expected.put("setting3", "none");
        expected.put("key2", "value2");
        expected.put("numbers1", Arrays.asList(1, 2, 3, 4));
        expected.put("numbers2", Arrays.asList(22, 33, 44, 55));
        expected.put("id", null);
        expected.put("default", Arrays.asList("value1", "value2"));
        expected.put("checked", true);
        expected.put("numbers4", Arrays.asList(4, 5, 6));
        expected.put("chars1", Arrays.asList("a", "b", "c"));
        expected.put("chars2", false);
        expected.put("obj1", Map.of("nestedKey", "value", "isNested", true));

        Assertions.assertThat(parser.parseToMap(jsonWithNestedMap)).isEqualTo(expected);
    }
}
