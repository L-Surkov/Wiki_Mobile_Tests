package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.GettingStartedScreen;

public class GettingStartedTests extends TestBase {

    GettingStartedScreen getStarted = new GettingStartedScreen();
    String firstScreenHeader = "The Free Encyclopedia\n…in over 300 languages";
    String secondScreenHeader = "New ways to explore";
    String thirdScreenHeader = "Reading lists with sync";
    String fourthScreenHeader = "Data";

    @Test
    @Tag("GettingStartedTests")
    @Description("Проверка корректного отображения экрана онбординга и заголовков")
    @DisplayName("Проверка корректного отображения экрана онбординга и заголовков")
    @Story("Онбординг")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    void getStartedScreenPositiveTest() {
        getStarted
                .primaryTextMatch(firstScreenHeader)
                .tapForwardButton()
                .primaryTextMatch(secondScreenHeader)
                .tapForwardButton()
                .primaryTextMatch(thirdScreenHeader)
                .tapForwardButton()
                .primaryTextMatch(fourthScreenHeader)
                .tapDoneButton();
    }
}