package ui.cucumber.steps;

import common.pojo.City;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import screenplay.questions.Application;
import screenplay.questions.TheFlights;
import screenplay.tasks.SearchFlights;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class FlightsSearchSteps {
    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) open the home page$")
    public void that_James_has_an_empty_todo_list(String actorName) throws Throwable {
        theActorCalled(actorName).wasAbleTo(screenplay.tasks.Start.withHomePage());
    }

    @Then("^(?:he|she) should see the home page with '(.*)' title and '(.*)' heading$")
    public void todo_list_should_contain(String title, String heading) throws Throwable {
        theActorInTheSpotlight().should(
                seeThat(Application.information(),
                        displays("title",equalTo(title)),
                        displays("heading",equalTo(heading))
                )
        );
    }

    @When("s?he search flights from (.*) to (.*)")
    public void searchFlightsBetween(String from, String to) {
        theActorInTheSpotlight().attemptsTo(SearchFlights.betweenCountries(City.fromString(from),City.fromString(to)));
    }

    @Then("^(?:he|she) should find some flights$")
    public void should_find_some_flights() throws Throwable {
        theActorInTheSpotlight().should(
                seeThat(
                        TheFlights.displayed(),
                        hasSize(greaterThan(0))
                )
        );
    }
}
