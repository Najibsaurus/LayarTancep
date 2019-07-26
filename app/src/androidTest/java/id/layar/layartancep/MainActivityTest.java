package id.layar.layartancep;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;



public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void toDetailMovieTest() {
        onView(withId(R.id.recyclerviewHome)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerviewHome)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.title_text)).check(matches(isDisplayed()));
        onView(withId(R.id.title_text)).check(matches(withText("The Lion King")));
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Test
    public void toDetailTvTest() {
        onView(withId(R.id.navigation_tv_show)).perform(click());
        onView(withId(R.id.recyclerviewTeve)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerviewTeve)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.title_text)).check(matches(isDisplayed()));
        onView(withId(R.id.title_text)).check(matches(withText("Cars")));
        onView(isRoot()).perform(ViewActions.pressBack());
    }


}