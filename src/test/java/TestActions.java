import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TestActions {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
 //       Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest()  {
        //Open and drug by Selenide.actions() - не запускается тк баг на сайте
        open("/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        actions().clickAndHold(elementB).moveToElement(elementA).release().perform();

        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));

    }
}
