package hexlet.code;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.net.URISyntaxException;

class DifferTest {

    private final String expectedStylish = Files.contentOf(
            new File(getClass().getClassLoader().getResource("expected-stylish.txt").toURI()), "UTF-8");
    private final String expectedPlain = Files.contentOf(
            new File(getClass().getClassLoader().getResource("expected-plain.txt").toURI()), "UTF-8");
    private final String expectedJson = Files.contentOf(
            new File(getClass().getClassLoader().getResource("expected-json.txt").toURI()), "UTF-8");

    DifferTest() throws URISyntaxException {
    }

    @ParameterizedTest
    @DisplayName("Should return diff depending on format param")
    @ValueSource(strings = {"json", "yml"})
    void shouldReturnDiffDependingOnFormatParam(String format) throws Exception {
        String filePath1 = new File(getClass().getClassLoader().getResource("nested-fixture-1." + format)
                .toURI()).toString();
        String filePath2 = new File(getClass().getClassLoader().getResource("nested-fixture-2." + format)
                .toURI()).toString();

        Assertions.assertThat(Differ.generate(filePath1, filePath2, "stylish")).isEqualTo(expectedStylish);
        Assertions.assertThat(Differ.generate(filePath1, filePath2, "plain")).isEqualTo(expectedPlain);
        Assertions.assertThat(Differ.generate(filePath1, filePath2, "json")).isEqualTo(expectedJson);
        Assertions.assertThat(Differ.generate(filePath1, filePath2)).isEqualTo(expectedStylish);
    }
}
