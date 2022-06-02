package hexlet.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

class FileReaderTest {

    @Test
    void readPropsFile() throws IOException, URISyntaxException {
        String filePath = new File(getClass().getClassLoader().getResource("testprops.json").toURI()).toString();
        Map<String, String> expected = Map.of("testPropName", "testValue");

        Assertions.assertThat(FileReader.readToMap(filePath)).isEqualTo(expected);
    }

    @Test
    void readToString() throws IOException, URISyntaxException {
        String filePath = new File(getClass().getClassLoader().getResource("testprops.json").toURI()).toString();
        String expected = "{\n  \"testPropName\": \"testValue\"\n}";

        Assertions.assertThat(FileReader.readToString(filePath)).isEqualTo(expected);
    }
}
