package screenplay.model;

public class ApplicationInformation {
    private final String title;
    private final String heading;

    public ApplicationInformation(String title, String heading) {
        this.title = title;
        this.heading = heading;
    }

    @Override
    public String toString() {
        return String.format("{title='%s', heading='%s'}", title, heading);
    }
}
