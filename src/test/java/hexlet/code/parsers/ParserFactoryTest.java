package hexlet.code.parsers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserFactoryTest {

    @Test()
    @DisplayName("Should return JsonParser when given json")
    void shouldReturnJsonParserWhenGivenJsonFilename() {
        Assertions.assertThat(ParserFactory.getParser("json")).isInstanceOf(JsonParser.class);
    }

    @ParameterizedTest
    @DisplayName("Should return YamlParser when given yaml")
    @ValueSource(strings = {"yaml", "yml"})
    void shouldReturnYamlParserWhenGivenYamlFilename(String fileType) {
        Assertions.assertThat(ParserFactory.getParser(fileType)).isInstanceOf(YamlParser.class);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentEx when given unsupported file type")
    void shouldThrowIllegalArgExWhenGivenUnsupportedFilename() {
        Assertions.assertThatThrownBy(() -> ParserFactory.getParser("not supported"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
