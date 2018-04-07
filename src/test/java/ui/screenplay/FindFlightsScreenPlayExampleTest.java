package ui.screenplay;

import common.pojo.City;
import common.pojo.RegularUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import screenplay.questions.Application;
import screenplay.questions.TheFlights;
import screenplay.tasks.SearchFlights;
import screenplay.tasks.Start;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("type:UI"),
        @WithTag("pattern:Screenplay")
})
public class FindFlightsScreenPlayExampleTest {
    private Actor yuri = RegularUser.named("Yuri");

    @Managed
    WebDriver hisDriver;

    @Before
    public void jamesCanBrowseTheWeb() {
        yuri.can(BrowseTheWeb.with(hisDriver));
    }


    @Test
    public void shouldBeAbleToFindFlightsFromBostonToNewYork() {
        givenThat(yuri).wasAbleTo(Start.withHomePage());

        then(yuri).should(
                seeThat(Application.information(),
                        displays("title",equalTo("BlazeDemo")),
                        displays("heading",equalTo("Welcome to the Simple Travel Agency!"))
                )
        );

        when(yuri).attemptsTo(
                SearchFlights.betweenCountries(City.Boston, City.NewYork)
        );

        then(yuri).should(
                    seeThat(
                            TheFlights.displayed(),
                            hasSize(greaterThan(0))
                )
        );
    }
}