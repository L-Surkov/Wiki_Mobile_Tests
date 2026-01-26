package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("MainTests")
@Epic("Функции главного экрана")
@Feature("Работа со статьями и текстом")
public class ManualTests {

    @Story("Добавление новости или статьи в избранное")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка корректного сохранения в избранное")
    @DisplayName("Проверка корректного сохранения в избранное")
    @Test
    void wikiSavedArticle() {
        Allure.step("Открыть главный экран приложения и пролистать до новостей");
        Allure.step("Перейти в любую тему");
        Allure.step("Нажать на заголовок и открыть новость");
        Allure.step("Нажать Save в нижнем левом углу");
        Allure.step("Несколько раз нажать стрелку назад и вернуться на главный экран");
        Allure.step("Перейти на вкладку Saved внизу");
        Allure.step("Проверить отображение новости, которая добавлялась в избранное");
    }

    @Story("Изменение темы на экране странице новости либо статьи")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("allure8")
    @Description("Проверка изменения темы на странице с текстом")
    @DisplayName("Проверка изменения темы на странице с текстом")
    @Test
    void wikiChangeThemeArticle() {
        Allure.step("Открыть главный экран приложения и пролистать до новостей");
        Allure.step("Перейти в любую тему");
        Allure.step("Нажать на заголовок и открыть новость");
        Allure.step("Нажать Theme в нижнем правом углу");
        Allure.step("Во всплывающем окне выбрать изменение размера шрифта");
        Allure.step("Нажать на область вне всплывающего окна");
        Allure.step("Проверить, что шрифт статьи увеличился соответственно выбранным настройкам");
    }
}
