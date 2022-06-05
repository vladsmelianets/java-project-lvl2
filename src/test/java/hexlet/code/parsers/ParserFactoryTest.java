package hexlet.code.parsers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserFactoryTest {

    @Test
    void Should_ReturnJsonParser_When_GivenJsonFilename() {
        Assertions.assertThat(ParserFactory.getParser(".json")).isInstanceOf(JsonParser.class);
    }

    @Test
    void Should_ReturnYamlParser_When_GivenYamlFilename() {
        Assertions.assertThat(ParserFactory.getParser(".yaml")).isInstanceOf(YamlParser.class);
    }

    @Test
    void Should_ThrowIllegalStateEx_When_GivenUnsupportedFilename() {
        Assertions.assertThatThrownBy(() -> ParserFactory.getParser("not supported"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}