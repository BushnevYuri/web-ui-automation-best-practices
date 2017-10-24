package pageobject.steps;

import pageobject.pages.FlightsPage;
import pageobject.pages.HomePage;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class FlightsSearchSteps extends BaseSteps {
    private HomePage homePage;
    private FlightsPage flightsPage;

    @Step
    public FlightsPage searchFlightsBetween(String from, String to) {
        homePage.findFlights(from, to);
        return new FlightsPage();
    }

    @Step
    public List<String> foundFlights(){
        return flightsPage.getFlights();
    }
}