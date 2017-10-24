package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.model.ApplicationInformation;
import screenplay.view.BlazeDemoHomePage;

import static net.serenitybdd.screenplay.questions.ValueOf.the;

public class Application implements Question<ApplicationInformation> {

    @Override
    public ApplicationInformation answeredBy(Actor actor) {
        String title = BrowseTheWeb.as(actor).getTitle();
        String heading = the(Text.of(BlazeDemoHomePage.MAIN_HEADING).viewedBy(actor));

        return new ApplicationInformation(title, heading);
    }

    public static Application information() {
        return new Application();
    }
}