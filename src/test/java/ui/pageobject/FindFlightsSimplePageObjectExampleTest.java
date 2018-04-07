package ui.pageobject;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pageobject.pages.FlightsPage;
import pageobject.pages.HomePage;

import static common.pojo.City.Boston;
import static common.pojo.City.NewYork;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("type:UI"),
        @WithTag("pattern:PageObject")
})
public class FindFlightsSimplePageObjectExampleTest {
    @Managed WebDriver driver;
    @Managed HomePage homePage;
    @Managed FlightsPage flightsPage;

    @Test
    public void userShouldBeAbleToFindFlightsFromBostonToNewYork(){
        homePage.open();
        homePage.waitUntilPageLoaded();

        Assert.assertEquals(homePage.getTitle(), "BlazeDemo");
        Assert.assertEquals(homePage.getHeadingText(), "Welcome to the Simple Travel Agency!");

        homePage.findFlights(Boston, NewYork);
        Assert.assertTrue(flightsPage.getFlights().size() > 0);
    }
}