package common;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoDownloadedWebDriver implements DriverSource {
    public enum WebBrowsers {
        CHROME, CHROME_HEADLESS
    }

    private BaseConfiguration baseConfiguration = new BaseConfiguration();

    @Override
    public WebDriver newDriver() {
        WebBrowsers browserType = WebBrowsers.valueOf(baseConfiguration.getProperty("browser"));

        switch (browserType) {
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver();

            case CHROME_HEADLESS:
                ChromeDriverManager.getInstance().setup();
                ChromeOptions chromeHeadlessOptions = new ChromeOptions();
                return new ChromeDriver(chromeHeadlessOptions);

            //other browsers if needed

            default:
                return null;
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
