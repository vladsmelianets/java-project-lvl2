package hexlet.code;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

class DifferTest {

    private String jsonPath1 = new File(getClass().getClassLoader().getResource("nested-json-fixture-1.json")
            .toURI()).toString();
    private String jsonPath2 = new File(getClass().getClassLoader().getResource("nested-json-fixture-2.json")
            .toURI()).toString();
    private String yamlPath1 = new File(getClass().getClassLoader().getResource("nested-yaml-fixture-1.yml")
            .toURI()).toString();
    private String yamlPath2 = new File(getClass().getClassLoader().getResource("nested-yaml-fixture-2.yml")
            .toURI()).toString();

    private String expectedStylish = Files.contentOf(
            new File(getClass().getClassLoader().getResource("expected-stylish.txt").toURI()), "UTF-8");
    private String expectedPlain = Files.contentOf(
            new File(getClass().getClassLoader().getResource("expected-plain.txt").toURI()), "UTF-8");
    private String expectedJson = Files.contentOf(
            new File(getClass().getClassLoader().getResource("expected-json.txt").toURI()), "UTF-8");

    DifferTest() throws URISyntaxException {
    }

    @Test
    @DisplayName("Should return stylish diff when given jsons and stylish")
    void shouldReturnStylishDiffWhenJsonsAndStylish() throws IOException {
        Assertions.assertThat(Differ.generate(jsonPath1, jsonPath2, "stylish")).isEqualTo(expectedStylish);
    }

    @Test
    @DisplayName("Should return plain diff when given jsons and plain")
    void shouldReturnPlainDiffWhenJsonsAndPlain() throws IOException {
        Assertions.assertThat(Differ.generate(jsonPath1, jsonPath2, "plain")).isEqualTo(expectedPlain);
    }

    @Test
    @DisplayName("Should return json diff when given jsons and json")
    void shouldReturnJsonDiffWhenJsonsAndJson() throws IOException {
        Assertions.assertThat(Differ.generate(jsonPath1, jsonPath2, "json")).isEqualTo(expectedJson);
    }

    @Test
    @DisplayName("Should return stylish diff when given yamls and stylish")
    void shouldReturnStylishDiffWhenYamlsAndStylish() throws IOException {
        Assertions.assertThat(Differ.generate(yamlPath1, yamlPath2, "stylish")).isEqualTo(expectedStylish);
    }

    @Test
    @DisplayName("Should return plain diff when given yamls and plain")
    void shouldReturnPlainDiffWhenYamlsAndPlain() throws IOException {
        Assertions.assertThat(Differ.generate(yamlPath1, yamlPath2, "plain")).isEqualTo(expectedPlain);
    }

    @Test
    @DisplayName("Should return json diff when given yamls and json")
    void shouldReturnJsonDiffWhenYamlsAndJson() throws IOException {
        Assertions.assertThat(Differ.generate(yamlPath1, yamlPath2, "json")).isEqualTo(expectedJson);
    }

    @Test
    @DisplayName("Should return stylish diff by default")
    void shouldReturnStylishDiffByDefault() throws IOException {
        Assertions.assertThat(Differ.generate(yamlPath1, yamlPath2)).isEqualTo(expectedStylish);
    }
}
