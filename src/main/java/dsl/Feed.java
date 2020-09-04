package dsl;

import matchers.MatcherAdapter;
import reports.JamaReport;
import reports.LoggerReport;
import reports.Reportable;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

// this is more a facade style where every method wraps actions
public class Feed {
    private final List<Reportable> allReporters = Arrays.asList(
            new JamaReport(), new LoggerReport()
    );

    public void withText(final String text) {
        // use the page object(s) to create the feed

        // get text from the page
        String actualText = "my feed";

        MatcherAdapter.assertThat(actualText, equalTo(text), "create new feed", allReporters);
    }
}
