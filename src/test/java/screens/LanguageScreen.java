package screens;
import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class LanguageScreen {

    private final ElementsCollection languageName = $$((AppiumBy.id("org.wikipedia.alpha:id/localized_language_name"))),
            checkLanguageText = $$(AppiumBy.className("android.widget.TextView"));

    @Step("Выбрать нужный язык текста")
    public LanguageScreen languageSelection(String value) {
        languageName.findBy(text(value));
        return this;
    }

    @Step("Проверить смену языка")
    public LanguageScreen checkLanguage(String value) {
        checkLanguageText.findBy(text(value)).shouldBe(visible);
        return this;
    }
}
