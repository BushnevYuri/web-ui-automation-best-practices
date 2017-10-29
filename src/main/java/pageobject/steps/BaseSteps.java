package pageobject.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pageobject.pages.HomePage;

public class BaseSteps extends ScenarioSteps {
    public HomePage homePage;

    @Step
    public void openHomePage() {
        homePage.open();
    }

    @Step
    public void verifySeeThatHomePageIsOpened() {
        homePage.waitUntilPageLoaded();
    }

    @Step
    public void verifyThatTitleAndHadingTextIsCorrect() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePage.getTitle()).isEqualTo("BlazeDemo");
        softly.assertThat(homePage.getHeadingText()).isEqualTo("Welcome to the Simple Travel Agency!");
        softly.assertAll();
    }
}