package common.framework;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AutoDownloadedWebDriver implements DriverSource {
    public enum WebBrowsers {
        CHROME, CHROME_HEADLESS, CHROME_ON_GRID
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

            case CHROME_ON_GRID:
                ChromeDriverManager.getInstance().setup();
                String Node = baseConfiguration.getProperty("selenium.grid.url");
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setBrowserName("chrome");
                try {
                    return new RemoteWebDriver(new URL(Node), cap);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            default:
                return null;
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
