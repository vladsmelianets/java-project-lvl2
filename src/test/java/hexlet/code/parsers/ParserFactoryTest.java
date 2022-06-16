package hexlet.code.parsers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserFactoryTest {

    @Test()
    @DisplayName("Should return JsonParser when given *.json")
    void shouldReturnJsonParserWhenGivenJsonFilename() {
        Assertions.assertThat(ParserFactory.getParser(FileType.JSON)).isInstanceOf(JsonParser.class);
    }

    @Test
    @DisplayName("Should return YamlParser when given *.yaml")
    void shouldReturnYamlParserWhenGivenYamlFilename() {
        Assertions.assertThat(ParserFactory.getParser(FileType.YAML)).isInstanceOf(YamlParser.class);
    }
}
