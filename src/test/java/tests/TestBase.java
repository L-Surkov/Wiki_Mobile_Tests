package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    void beforeEach() {
        Configuration.browser = BrowserstackDriver.class.getName();

        System.out.println("=== TESTBASE CONFIGURATION ===");
        System.out.println("Browser: " + Configuration.browser);
        System.out.println("Driver class: " + BrowserstackDriver.class.getName());
        System.out.println("=========================");


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println("Session ID: " + sessionId);
    }
}
