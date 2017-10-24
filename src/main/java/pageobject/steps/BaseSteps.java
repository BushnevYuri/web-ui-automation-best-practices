package pageobject.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pageobject.pages.HomePage;

public class BaseSteps extends ScenarioSteps {
    public HomePage homePage;

    @Step
    public void openHomePage() {
        homePage.open();
    }

    @Step
    public void shouldSeeThatHomePageIsOpened() {
        homePage.waitUntilPageLoaded();
    }
}