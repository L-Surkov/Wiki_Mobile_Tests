package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.SearchScreen;

@Tag("SearchTests")
public class SearchTests extends TestBase {

    private final SearchScreen searchScreen = new SearchScreen();

    @Test
    @Description("Проверка поисковой строки и вывода релевантного значения в поиске")
    void successfulSearchTest() {
        String searchTerm = "Appium";
        searchScreen.openSearch();
        searchScreen.typeSearch(searchTerm);
        searchScreen.verifyResultsArePresent();
    }

    @Test
    @Description("Проверка поисковой строки и открытия статьи при клике на результат")
    void searchAndOpenArticle() {
        String searchTerm = "RestApi";
        String expectedTitle = "REST";
        searchScreen.openSearch();
        searchScreen.typeSearch(searchTerm);
        searchScreen.clickFirstResult();
        searchScreen.verifyTitleIs(expectedTitle);
    }
}