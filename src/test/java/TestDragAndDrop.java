import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestDragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
 //       Configuration.holdBrowserOpen = true;
    }

    @Test
    void dragAndDropTo()  {
        open("/drag_and_drop");
        //Open and drug by dragAndDropTo
        //в следующей строке dragAndDropTo был деприкейтед  убрала деприкейшн и работает но что это было для меня загадка
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}
