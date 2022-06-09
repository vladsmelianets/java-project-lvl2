package hexlet.code.parsers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserFactoryTest {

    @Test()
    @DisplayName("Should return JsonParser when given *.json")
    void shouldReturnJsonParserWhenGivenJsonFilename() {
        Assertions.assertThat(ParserFactory.getParser("./file.json")).isInstanceOf(JsonParser.class);
    }

    @Test
    @DisplayName("Should return YamlParser when given *.yaml")
    void shouldReturnYamlParserWhenGivenYamlFilename() {
        Assertions.assertThat(ParserFactory.getParser("./file.yml")).isInstanceOf(YamlParser.class);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentEx when given unsupported filename")
    void shouldThrowIllegalArgExWhenGivenUnsupportedFilename() {
        Assertions.assertThatThrownBy(() -> ParserFactory.getParser("not supported"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
