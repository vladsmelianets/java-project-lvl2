package hexlet.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class PropsChangeDetectorTest {

    PropsChangeDetector changeDetector = new PropsChangeDetector();

    @Test
    void compareProps() {
        Map<String, String> firstProps = Map.of("prop1", "val1", "prop2", "val2", "prop3", "val3");
        Map<String, String> secondProps = Map.of("prop1", "val1", "prop3", "modified val3");

        Map<String, String> expected = Map.of(
                "prop1: val1", "",
                "prop2: val2", "-",
                "prop3: val3", "-",
                "prop3: modified val3", "+");

        Assertions.assertThat(changeDetector.compareProps(firstProps, secondProps)).isEqualTo(expected);
    }
}
