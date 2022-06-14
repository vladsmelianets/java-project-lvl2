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
    @DisplayName("Should return stylish diff when given stylish format param")
    @ValueSource(strings = {"json", "yml"})
    void shouldReturnStylishDiffWhenGivenStylishFormatParam(String format) throws Exception {
        String filePath1 = new File(getClass().getClassLoader().getResource("nested-fixture-1." + format)
                .toURI()).toString();
        String filePath2 = new File(getClass().getClassLoader().getResource("nested-fixture-2." + format)
                .toURI()).toString();

        Assertions.assertThat(Differ.generate(filePath1, filePath2, "stylish")).isEqualTo(expectedStylish);
    }

    @ParameterizedTest
    @DisplayName("Should return plain diff when given plain format param")
    @ValueSource(strings = {"json", "yml"})
    void shouldReturnPlainDiffWhenGivenPlainFormatParam(String format) throws Exception {
        String filePath1 = new File(getClass().getClassLoader().getResource("nested-fixture-1." + format)
                .toURI()).toString();
        String filePath2 = new File(getClass().getClassLoader().getResource("nested-fixture-2." + format)
                .toURI()).toString();

        Assertions.assertThat(Differ.generate(filePath1, filePath2, "plain")).isEqualTo(expectedPlain);
    }

    @ParameterizedTest
    @DisplayName("Should return json diff when given json format param")
    @ValueSource(strings = {"json", "yml"})
    void shouldReturnJsonDiffWhenGivenJsonFormatParam(String format) throws Exception {
        String filePath1 = new File(getClass().getClassLoader().getResource("nested-fixture-1." + format)
                .toURI()).toString();
        String filePath2 = new File(getClass().getClassLoader().getResource("nested-fixture-2." + format)
                .toURI()).toString();

        Assertions.assertThat(Differ.generate(filePath1, filePath2, "json")).isEqualTo(expectedJson);
    }

    @ParameterizedTest
    @DisplayName("Should return stylish diff by default when without format param")
    @ValueSource(strings = {"json", "yml"})
    void shouldReturnStylishDiffByDefault(String format) throws Exception {
        String filePath1 = new File(getClass().getClassLoader().getResource("nested-fixture-1." + format)
                .toURI()).toString();
        String filePath2 = new File(getClass().getClassLoader().getResource("nested-fixture-2." + format)
                .toURI()).toString();

        Assertions.assertThat(Differ.generate(filePath1, filePath2)).isEqualTo(expectedStylish);
    }
}
