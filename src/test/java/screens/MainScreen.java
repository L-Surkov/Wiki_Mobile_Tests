package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {

    private final SelenideElement searchWikipedia = $(accessibilityId("Search Wikipedia")),
            moreButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),
            loginButton = $(id("org.wikipedia.alpha:id/explore_overflow_account_container")),
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
        moreButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Log in to Wikipedia'")
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
