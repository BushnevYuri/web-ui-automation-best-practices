package pageobject.pages;

import common.pojo.City;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.concurrent.TimeUnit;

@DefaultUrl("http://blazedemo.com/")
public class HomePage extends PageObject {
    /*
        SELECTORS
     */
    private static final String MAIN_HEADING_LABEL = "css:.jumbotron>.container>h1";
    private static final String FLIGHT_FROM_SELECTOR = "css:.form-inline:nth-of-type(1)";
    private static final String FLIGHT_TO_SELECTOR = "css:.form-inline:nth-of-type(2)";
    private static final String SEARCH_FLIGHT_BUTTON = "css:input[value='Find Flights']";

    /*
        ACTIONS
     */
    public FlightsPage findFlights(City from, City to){
        $(FLIGHT_FROM_SELECTOR).selectByValue(from.getFullName());
        $(FLIGHT_TO_SELECTOR).selectByValue(to.getFullName());
        $(SEARCH_FLIGHT_BUTTON).click();
        return new FlightsPage();
    }

    public void waitUntilPageLoaded(){
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(MAIN_HEADING_LABEL);
    }

    public String getHeadingText(){
        return $(MAIN_HEADING_LABEL).getText();
    }
}