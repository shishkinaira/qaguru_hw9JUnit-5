package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest extends TestBase {

    static Stream<Arguments> homepageLocalizationTest() {
        return Stream.of(
                Arguments.of(Locale.RU, List.of("Откройте")),
                Arguments.of(Locale.ENG, List.of("Discover")),
                Arguments.of(Locale.GRK, List.of("Ανακαλύψτε"))
        );
    }

    @Tag("smoke")
    @MethodSource
    @ParameterizedTest(name = "Check Homepage localization by MethodSource")
    void homepageLocalizationTest(Locale locale, List<String> wordOnTheLanguage) {
        open(baseUrl);
        $(".bubble-element .dropdown-chevron").selectOption(String.valueOf(locale));
        $$(".cmcaUj").shouldHave(CollectionCondition.texts(wordOnTheLanguage));
    }


    @Tag("smoke")
    @CsvSource(value = {"RU | Откройте",
                        "ENG | Discover",
                        "GRK | Ανακαλύψτε"},
            delimiter = '|')
    @ParameterizedTest(name = "Check Homepage localization by CsvSource for {0}")
    void homepageLocalizationTestByCsv(Locale locale, String wordOnTheLanguage) {
        open(baseUrl);
        $(".bubble-element .dropdown-chevron").selectOption(String.valueOf(locale));
        $$(".cmcaUj").shouldHave(CollectionCondition.texts(wordOnTheLanguage));
    }

    @Tag("smoke")
    @ParameterizedTest(name = "Check Homepage Has Language Select by EnumSource")
    @EnumSource(Locale.class)
    void homepageHasLanguagesSelectTestByEnum(Locale locale) {
        open(baseUrl);
        $(".bubble-element .dropdown-chevron").selectOption(String.valueOf(locale));
        $$(".baTaGaXa").shouldHave(CollectionCondition.texts(String.valueOf(locale)));
    }
}
