package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.id;

public class LoginScreen {

    private final SelenideElement usernameField = $x("//android.widget.EditText[@text=\"Username\"]");
    private final SelenideElement passwordField = $x("//android.widget.EditText[@text=\"Password\"]");
    private final SelenideElement loginButton = $(id("org.wikipedia.alpha:id/login_button"));
    private final SelenideElement errorTable = $(id("org.wikipedia.alpha:id/snackbar_text"));


    @Step("Ввести логин в поле Username")
    public LoginScreen usernameInput(String value) {
        usernameField.sendKeys(value);
        return this;
    }

    @Step("Ввести пароль в поле Password")
    public LoginScreen passwordInput(String value) {
        passwordField.sendKeys(value);
        return this;
    }

    @Step("Нажать кнопку авторизации после ввода пароля")
    public LoginScreen loginButtonClick() {
        loginButton.click();
        return this;
    }

    @Step("Проверить наличие текста об ошибке авторизации")
    public LoginScreen checkErrorText(String value) {
        errorTable.shouldHave(text(value));
        return this;
    }
}
