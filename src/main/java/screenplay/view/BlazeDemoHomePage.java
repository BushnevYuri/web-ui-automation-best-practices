package screenplay.view;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BlazeDemoHomePage {
    public final static Target MAIN_HEADING = Target.the("main heading").locatedBy(".jumbotron>.container>h1");
    public final static Target FLIGHT_FROM = Target.the("flight from").located(By.cssSelector(".form-inline:nth-of-type(1)"));
    public final static Target FLIGHT_TO = Target.the("flight to").located(By.cssSelector(".form-inline:nth-of-type(2)"));
    public final static Target SEARCH_FLIGHT_BUTTON = Target.the("flight to").located(By.cssSelector("input[value='Find Flights']"));
}
