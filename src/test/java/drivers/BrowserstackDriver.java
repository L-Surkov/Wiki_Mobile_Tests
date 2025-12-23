package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigReader;
import config.TestConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        TestConfig config = ConfigReader.INSTANCE.getConfig();

        MutableCapabilities caps = new MutableCapabilities();

        // Обязательные credentials (W3C-формат)
        String user = config.browserstackUser();
        String key = config.browserstackKey();

        if (user == null || user.isEmpty()) {
            throw new RuntimeException("BrowserStack user is not configured");
        }
        if (key == null || key.isEmpty()) {
            throw new RuntimeException("BrowserStack key is not configured");
        }

        caps.setCapability("browserstack:user", config.browserstackUser());
        caps.setCapability("browserstack:key", config.browserstackKey());

        System.out.println("BS User: " + user);
        System.out.println("BS Key: " + key);

        // Настройки теста (W3C-формат)
        caps.setCapability("browserstack:project", config.project());
        caps.setCapability("browserstack:build", config.buildName());
        caps.setCapability("browserstack:name", config.testName());

        // Устройство и ОС
        caps.setCapability("browserstack:deviceName", config.deviceName());
        caps.setCapability("browserstack:osVersion", config.osVersion());


        // Приложение и автоматизация
        caps.setCapability("browserstack:app", config.app());
        caps.setCapability("appium:automationName", config.appiumAutomationName());

        try {
            return new RemoteWebDriver(
                    new URL("https://hub-cloud.browserstack.com/wd/hub"),
                    caps
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack URL", e);
        }
    }
}
