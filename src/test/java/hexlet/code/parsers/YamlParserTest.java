package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class YamlParserTest {

    private static final int TIMEOUT_VAL = 50; // to satisfy linter's paranoia
    private final YamlParser parser = new YamlParser();

    @Test
    void parseToMap() throws JsonProcessingException {
        String yaml = """
                follow: false
                host: hexlet.io
                proxy: 123.234.53.22
                timeout: 50""";

        Map<String, Object> expected = Map.of("follow", false,
                "host", "hexlet.io",
                "proxy", "123.234.53.22",
                "timeout", TIMEOUT_VAL);

        Assertions.assertThat(parser.parseToMap(yaml)).isEqualTo(expected);
    }
}
