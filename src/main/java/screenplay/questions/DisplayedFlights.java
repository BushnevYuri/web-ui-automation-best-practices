package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.view.FlightsTablePage;

import java.util.List;


public class DisplayedFlights implements Question<List<String>> {
    public static int flightsCount;

    @Override
    public List<String> answeredBy(Actor actor) {
        List<String> flights = Text.of(FlightsTablePage.FLIGHTS)
                .viewedBy(actor)
                .asList();
        flightsCount = flights.size();
        return flights;
    }

    public static int getFlightsCount() {
        return flightsCount;
    }
}