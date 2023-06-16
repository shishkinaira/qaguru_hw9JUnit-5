import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TestDragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
 //       Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest() throws InterruptedException {
        //Open and drug by Selenide.actions() - не смогла запустить
        open("/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        actions().clickAndHold(elementB).moveToElement(elementA).release().perform();
//        $("#column-a").shouldHave(text("B"));
//        $("#column-b").shouldHave(text("A"));
        sleep(2000);

        //Open and drug by dragAndDropTo
        //в следующей строке dragAndDropTo был деприкейтед  убрала деприкейшн и работает но что это было для меня загадка
        $("#column-b").dragAndDropTo("#column-a");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        sleep(3000);

    }
}
