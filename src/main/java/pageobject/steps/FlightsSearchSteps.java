package pageobject.steps;

import common.pojo.City;
import pageobject.pages.FlightsPage;
import pageobject.pages.HomePage;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class FlightsSearchSteps extends BaseSteps {
    private HomePage homePage;
    private FlightsPage flightsPage;

    @Step
    public FlightsPage searchFlightsBetween(City from, City to) {
        homePage.findFlights(from, to);
        return new FlightsPage();
    }

    @Step
    public List<String> foundFlights(){
        return flightsPage.getFlights();
    }
}