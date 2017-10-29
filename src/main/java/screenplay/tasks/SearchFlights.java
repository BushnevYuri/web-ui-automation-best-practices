package screenplay.tasks;

import common.City;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import screenplay.view.BlazeDemoHomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFlights implements Task {
    private final String from;
    private final String to;

    @Step("{0} search flights from **#from** to **#to**")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byValue(from).from(BlazeDemoHomePage.FLIGHT_FROM),
                SelectFromOptions.byValue(to).from(BlazeDemoHomePage.FLIGHT_TO),
                Click.on(BlazeDemoHomePage.SEARCH_FLIGHT_BUTTON)
        );
    }

    public static SearchFlights betweenCountries(City from, City to) {
        return instrumented(SearchFlights.class,  from, to);
    }

    public SearchFlights(String from, String to){
        this.from = from;
        this.to = to;
    }
}
