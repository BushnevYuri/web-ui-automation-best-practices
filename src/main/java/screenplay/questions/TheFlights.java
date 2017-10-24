package screenplay.questions;

import net.serenitybdd.screenplay.Question;

import java.util.List;

public class TheFlights {
    public static Question<List<String>> displayed() {
        return new DisplayedFlights();
    }
}
