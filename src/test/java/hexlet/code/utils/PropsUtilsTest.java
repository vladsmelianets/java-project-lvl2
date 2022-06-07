package hexlet.code.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

class PropsUtilsTest {

    @Test
    void compareProps() {
        Map<String, Object> firstProps = Map.of("prop1", "val1", "prop2", "val2", "prop3", "val3");
        Map<String, Object> secondProps = Map.of("prop1", "val1", "prop3", "modified val3");

        Map<String, String> expected = Map.of(
                "prop1: val1", " ",
                "prop2: val2", "-",
                "prop3: val3", "-",
                "prop3: modified val3", "+");

        Assertions.assertThat(PropsUtils.getDifference(firstProps, secondProps)).isEqualTo(expected);
    }

    @Test
    void shouldReturnFlatDifferenceMapWhenGivenMapsWithNestedValues() {
        Map<String, Object> firstProps = Map.of(
                "prop1", "val1",
                "prop2", "val2",
                "prop3", "val3");
        Map<String, Object> secondProps = Map.of(
                "prop1", "val1",
                "prop3", "modified val3",
                "nested", Arrays.asList(1, 2, 3));

        Map<String, String> expected = Map.of(
                "nested: [1, 2, 3]", "+",
                "prop1: val1", " ",
                "prop2: val2", "-",
                "prop3: val3", "-",
                "prop3: modified val3", "+");

        Assertions.assertThat(PropsUtils.getDifference(firstProps, secondProps)).isEqualTo(expected);
    }
}
