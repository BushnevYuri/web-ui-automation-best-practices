package ui.pageobject;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pageobject.steps.FlightsSearchSteps;

import static common.pojo.City.Boston;
import static common.pojo.City.NewYork;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("type:UI"),
        @WithTag("pattern:PageObject")
})
public class FindFlightsPageObjectWithStepsExampleTest {
    @Managed WebDriver driver;

    @Steps
    FlightsSearchSteps yuri;
    //FlightsSearchSteps flightsSearchSteps; // this steps property name can be used in case you have different steps

    @Test
    public void shouldBeAbleToFindFlightsFromBostonToNewYork() {
        //GIVEN
        yuri.openHomePage();
        //THEN
        yuri.verifySeeThatHomePageIsOpened();
        //AND
        yuri.verifyThatTitleAndHadingTextIsCorrect();

        //WHEN
        yuri.searchFlightsBetween(Boston, NewYork);
        //THEN
        assertThat(yuri.foundFlights().size(), greaterThan(0));
    }
}