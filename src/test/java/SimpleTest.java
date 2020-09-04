import dsl.Feed;
import dsl.Search;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SimpleTest {
    @Test
    public void feedTest() {
        Feed feed = new Feed();

        feed.withText("my feed");
    }

    @Test
    public void searchTest() {
        new Search()
            .forASearchWithText("my input search")
            .theResultShouldBe(Arrays.asList("r1", "r2"))
            .theTotalPagesShouldBe(0);
    }
}
