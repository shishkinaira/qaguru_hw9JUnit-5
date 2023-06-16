import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestHoverAndPageOpen {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://github.com/";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest() {

        //Open page by hover and click on submenu
        open(baseUrl);
        $(".header-menu-wrapper").$(byText("Solutions")).hover().click();
        $("[href='/enterprise']").click();


        //Check page has text
        $(".enterprise-hero").shouldHave(text("Build like the best"));
    }

}
