package hexlet.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

class PropertiesFileReaderTest {

    @Test
    void readPropsFile() throws IOException, URISyntaxException {
        String filePath = new File(getClass().getClassLoader().getResource("testprops.json").toURI()).toString();
        Map<String, String> expected = Map.of("testPropName", "testValue");

        Assertions.assertThat(PropertiesFileReader.readPropsFile(filePath)).isEqualTo(expected);
    }
}
