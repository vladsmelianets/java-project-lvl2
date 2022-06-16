package hexlet.code.formatters;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FormatterFactoryTest {

    @Test()
    @DisplayName("Should return StylishFormatter when given \"stylish\"")
    void shouldStylishFormatterWhenGivenStylish() {
        Assertions.assertThat(FormatterFactory.getFormatter(Format.STYLISH)).isInstanceOf(StylishFormatter.class);
    }

    @Test
    @DisplayName("Should return PlainFormatter when given \"plain\"")
    void shouldReturnPlainFormatterWhenGivenPlain() {
        Assertions.assertThat(FormatterFactory.getFormatter(Format.PLAIN)).isInstanceOf(PlainFormatter.class);
    }

    @Test
    @DisplayName("Should return JsonFormatter when given \"json\"")
    void shouldReturnJsonFormatterWhenGivenJson() {
        Assertions.assertThat(FormatterFactory.getFormatter(Format.JSON)).isInstanceOf(JsonFormatter.class);
    }
}
