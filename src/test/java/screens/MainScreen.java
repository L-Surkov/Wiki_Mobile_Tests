package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {

    private final SelenideElement searchWikipedia = $(accessibilityId("Search Wikipedia")),
            moreButton = $(id("org.wikipedia.alpha:id/menu_icon")),
            loginButton = $(id("org.wikipedia.alpha:id/main_drawer_login_button")),
            navigationButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),
            settingButton = $(id("org.wikipedia.alpha:id/explore_overflow_settings"));
    private final ElementsCollection card = $$(id("org.wikipedia.alpha:id/view_card_header_title"));

    @Step("Нажать на строку поиска Википедии")
    public MainScreen searchClick() {
        searchWikipedia.click();
        return this;
    }

    @Step("Нажать на кнопку 'More'")
    public MainScreen moreClick() {
        ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("mobile: click", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) moreButton.toWebElement()).getId()
                ));
        return this;
    }

    @Step("Нажать на кнопку 'Log in/ join Wikipedia'")
    public MainScreen loginClick() {
        loginButton.click();
        return this;
    }

    @Step("Проверить наличие 'In the News'")
    public MainScreen checkInTheNews(String value) {
        card.findBy(text(value)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Нажать на кнопку 'Навигация'")
    public MainScreen navigationPress() {
        navigationButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Settings'")
    public MainScreen settingsButtonClick() {
        settingButton.click();
        return this;

    }
}
