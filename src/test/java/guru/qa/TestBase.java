package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://cyproplan.com/";
        Configuration.browserSize = "1920x1080";
        //   Configuration.holdBrowserOpen = true;
    }
}
