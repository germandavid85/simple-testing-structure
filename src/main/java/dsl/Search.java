package dsl;

import matchers.MatcherAdapter;
import reports.JamaReport;
import reports.LoggerReport;
import reports.Reportable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

// this is a methods pipe style where the methods can be chained to perform actions
public class Search {
    private final List<Reportable> allReporters = Arrays.asList(
            new JamaReport(), new LoggerReport()
    );
    private final List<String> searchResults = new ArrayList<>();
    private int totalPages = 0;
    private String inputText = "";

    public Search forASearchWithText(final String text) {
        this.inputText = text;

        // do the actual search
        List<String> results = Arrays.asList("r1", "r2");

        searchResults.clear();
        searchResults.addAll(results);

        return this;
    }

    public Search theResultShouldBe(List<String> expectedResults) {
        MatcherAdapter.assertThat(this.searchResults, equalTo(expectedResults), "search results", allReporters);

        return this;
    }

    public Search theTotalPagesShouldBe(int expectedTotalPages) {
        MatcherAdapter.assertThat(this.totalPages, equalTo(expectedTotalPages), "search total pages", allReporters);

        return this;
    }


}
