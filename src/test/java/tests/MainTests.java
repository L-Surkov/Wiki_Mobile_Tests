package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import screens.*;
import utils.TestDataUtils;

@Tag("MainTests")
public class MainTests extends TestBase {

    private final SearchScreen searchScreen = new SearchScreen();
    private final MainScreen mainScreen = new MainScreen();
    private final GettingStartedScreen gettingStartedScreen = new GettingStartedScreen();
    private final LoginScreen loginScreen = new LoginScreen();
    private final CreateAccountScreen createAccountScreen = new CreateAccountScreen();
    private final SettingScreen settingScreen = new SettingScreen();
    private final LanguageScreen languageScreen = new LanguageScreen();
    private final TestDataUtils testDataUtils = new TestDataUtils();

    @Test
    @Description("Проверка поисковой строки и вывода релевантного значения в поиске")
    @DisplayName("Тестирование поиска")
    void successfulSearchTest() {
        String searchTerm = "Appium";
        searchScreen.openSearch();
        searchScreen.typeSearch(searchTerm);
        searchScreen.verifyResultsArePresent();
    }

    @Test
    @Description("Проверка поисковой строки и открытия статьи при клике на результат - негативный")
    @DisplayName("Тестирование поиска - негативный сценарий")
    void searchAndOpenArticleNegative() {
        String searchTerm = "RestApi";
        String expectedTitle = "REST";
        searchScreen.openSearch();
        searchScreen.typeSearch(searchTerm);
        searchScreen.clickFirstResult();
        searchScreen.checkErrorIcon();
    }

    @Test
    @Description("Проверка отображения заголовка In the News на главном экране приложения")
    @DisplayName("Тестирование наличия заголовка на главном экране")
    void inTheNewsSectionTest() {
        mainScreen.checkInTheNews("In the News");
    }

    @Test
    @Description("Проверка невозможности входа в личный кабинет после ввода некорректных данных")
    @DisplayName("Тестирование авторизации - негативный сценарий")
    void unsuccessfulLoginTest() {
        gettingStartedScreen.skipButtonClick();
        mainScreen.moreClick();
        mainScreen.loginClick();
        createAccountScreen.authLoginClick();
        loginScreen.usernameInput(testDataUtils.username)
                .passwordInput(testDataUtils.password)
                .loginButtonClick()
                .checkErrorText("Incorrect username or password entered.");

    }

    @Test
    @Description("Проверка возможности смены языка в настройках приложения")
    @DisplayName("Тестирование смены языка текста в настройках")
    void languageSettingTest() {
        mainScreen.navigationPress()
                .settingsButtonClick();
        settingScreen.languageListClick();
        languageScreen.languageSelection("Русский")
                .checkLanguage("Русский");

    }
}