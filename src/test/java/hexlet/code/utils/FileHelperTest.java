package hexlet.code.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

class FileHelperTest {

    @Test
    void readToString() throws IOException, URISyntaxException {
        String filePath = new File(getClass().getClassLoader().getResource("testprops.json").toURI()).toString();
        String expected = "{\n  \"testPropName\": \"testValue\"\n}";

        Assertions.assertThat(FileHelper.readToString(filePath)).isEqualTo(expected);
    }
}
