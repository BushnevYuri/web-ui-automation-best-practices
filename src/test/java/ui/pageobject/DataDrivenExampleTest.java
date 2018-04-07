package ui.pageobject;

import common.pojo.City;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pageobject.pages.FlightsPage;
import pageobject.pages.HomePage;

import java.util.Arrays;
import java.util.Collection;

import static common.pojo.City.*;

@RunWith(SerenityParameterizedRunner.class)
@WithTags({
        @WithTag("type:UI"),
        @WithTag("pattern:PageObject")
})
@Concurrent
public class DataDrivenExampleTest {
    @Managed WebDriver driver;
    @Managed HomePage homePage;
    @Managed FlightsPage flightsPage;

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {Boston, NewYork},
                {Boston, Berlin},
                {Portland, Rome},
                {Paris, Berlin}
        });
    }

    private final City cityFrom;
    private final City cityTo;

    public DataDrivenExampleTest(City cityFrom, City cityTo) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    @Test
    public void verifySearchBetweenDifferentLocations(){
        homePage.open();
        homePage.waitUntilPageLoaded();

        homePage.findFlights(cityFrom, cityTo);
        Assert.assertTrue(flightsPage.getFlights().size() > 0);
    }
}