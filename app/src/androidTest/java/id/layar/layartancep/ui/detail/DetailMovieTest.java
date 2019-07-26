package id.layar.layartancep.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import id.layar.layartancep.R;
import id.layar.layartancep.data.Movies;
import id.layar.layartancep.utils.FakeDataGenerator;
import id.layar.layartancep.utils.RecyclerViewItemCountAssertion;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class DetailMovieTest {

    private Movies dummyMovies = FakeDataGenerator.generateDataMovie().get(0);


    @Rule
    public ActivityTestRule<DetailMovie> activityRule = new ActivityTestRule<DetailMovie>(DetailMovie.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailMovie.class);
            result.putExtra("title", dummyMovies.getTitle());
            result.putExtra("description", dummyMovies.getOverview());
            result.putExtra("image", dummyMovies.getPoster_path());

            return result;
        }
    };


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadMovieDetail(){
        onView(withId(R.id.title_text)).check(matches(isDisplayed()));
        onView(withId(R.id.title_text)).check(matches(withText(dummyMovies.getTitle())));
        onView(withId(R.id.description)).check(matches(isDisplayed()));
        onView(withId(R.id.description)).check(matches(withText(dummyMovies.getOverview())));
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));
    }
}