package matchers;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import reports.Reportable;

import java.util.List;

public class MatcherAdapter {

    public static <T> void assertThat(final T actual, final Matcher<? super T> matcher, final String message, final List<Reportable> reports) {
        assertThat("", actual, matcher, message, reports);
    }

    public static <T> void assertThat(final String reason, final T actual, final Matcher<? super T> matcher, final String message, final List<Reportable> reports) {
        try {
            MatcherAssert.assertThat(reason, actual, matcher);
        } catch (AssertionError e) {
            String failedMessage = message + " was failed";

            sendReports(reports, failedMessage);

            throw e;
        }

        String passedMessage = message + " was passed";

        sendReports(reports, passedMessage);
    }

    public static void assertThat(final String reason, final boolean assertion, final String message, final List<Reportable> reports) {
        try {
            MatcherAssert.assertThat(reason, assertion);
        } catch (AssertionError e) {
            String failedMessage = message + " was failed";

            sendReports(reports, failedMessage);

            throw e;
        }

        String passedMessage = message + " was passed";

        sendReports(reports, passedMessage);
    }

    private static void sendReports(final List<Reportable> reports, final String message) {
        for (Reportable report : reports) {
            report.report(message);
        }

    }
}
