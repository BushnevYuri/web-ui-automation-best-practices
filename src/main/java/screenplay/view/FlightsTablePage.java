package screenplay.view;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightsTablePage {
    public final static Target FLIGHTS = Target.the("fights").located(By.cssSelector(".table tbody tr td:nth-of-type(2)"));
}
