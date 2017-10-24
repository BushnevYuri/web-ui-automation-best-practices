package screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Step;
import pageobject.pages.HomePage;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Start implements Task {
    private HomePage homePage;
    private final String pageDescription;

    @Step("{0} starts with **#pageDescription**")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(homePage)
        );
    }

    public static Start withHomePage() {
        return instrumented(Start.class,  "Home page");
    }

    public Start(String pageDescription) {
        this.pageDescription = pageDescription;
    }
}
