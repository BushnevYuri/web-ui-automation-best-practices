package screenplay.tasks;

import common.pojo.City;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import screenplay.view.BlazeDemoHomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFlights implements Task {
    private final City from;
    private final City to;

    @Step("{0} search flights from **#from** to **#to**")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byValue(from.getFullName()).from(BlazeDemoHomePage.FLIGHT_FROM),
                SelectFromOptions.byValue(to.getFullName()).from(BlazeDemoHomePage.FLIGHT_TO),
                Click.on(BlazeDemoHomePage.SEARCH_FLIGHT_BUTTON)
        );
    }

    public static SearchFlights betweenCountries(City from, City to) {
        return instrumented(SearchFlights.class,  from, to);
    }

    public SearchFlights(City from, City to){
        this.from = from;
        this.to = to;
    }
}
