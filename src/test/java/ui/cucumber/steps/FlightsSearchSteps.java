package ui.cucumber.steps;

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
        theActorInTheSpotlight().attemptsTo(SearchFlights.betweenCountries("Boston","New York"));
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




//
//
//
//
//    @Given("^that (.*) has a todo list containing (.*)$")
//    public void that_James_has_an_empty_todo_list(String actorName, List<String> items) throws Throwable {
//        theActorCalled(actorName).wasAbleTo(Start.withATodoListContaining(items));
//    }
//
//    @When("^s?he adds '(.*)' to (?:his|her|the) list$")
//    public void adds_Buy_some_milk_to_his_list(String item) throws Throwable {
//        theActorInTheSpotlight().attemptsTo(AddATodoItem.called(item));
//    }
//
//
//
//    @Then("^s?he has completed the task called '(.*)'$")
//    public void completes_task_called(String item) throws Throwable {
//        theActorInTheSpotlight().attemptsTo(
//                CompleteItem.called(item)
//        );
//    }
//
//    @When("s?he filters her list to show only (.*) tasks")
//    public void filters_tasks_by(TodoStatusFilter status) {
//        theActorInTheSpotlight().attemptsTo(FilterItems.toShow(status));
//    }
//
//    @Then("^(.*)'s todo list should contain (.*)$")
//    public void a_users_todo_list_should_contain(String actorName, List<String> expectedItems) throws Throwable {
//        theActorCalled(actorName).should(seeThat(TheItems.displayed(), equalTo(expectedItems)));
//    }
//
//    @Then("^'(.*)' should be recorded in (?:his|her|the) list$")
//    public void item_should_be_recorded_in_the_list(String expectedItem) throws Throwable {
//       theActorInTheSpotlight().should(seeThat(TheItems.displayed(), hasItem(expectedItem)));
//    }
}
