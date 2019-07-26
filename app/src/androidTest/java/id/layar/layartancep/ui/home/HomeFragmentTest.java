package id.layar.layartancep.ui.home;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import id.layar.layartancep.R;
import id.layar.layartancep.testing.SingleFragmentActivity;
import id.layar.layartancep.utils.RecyclerViewItemCountAssertion;

import static org.junit.Assert.*;

public class HomeFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private HomeFragment homeFragment = new HomeFragment();

    @Before
    public void setUp(){
        activityRule.getActivity().setFragment(homeFragment);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadMovie(){
        onView(withId(R.id.recyclerviewHome)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerviewHome)).check(new RecyclerViewItemCountAssertion(12));
    }


}