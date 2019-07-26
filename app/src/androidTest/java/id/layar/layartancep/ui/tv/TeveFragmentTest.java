package id.layar.layartancep.ui.tv;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import id.layar.layartancep.R;
import id.layar.layartancep.testing.SingleFragmentActivity;
import id.layar.layartancep.ui.home.HomeFragment;
import id.layar.layartancep.utils.RecyclerViewItemCountAssertion;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class TeveFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TeveFragment teveFragment = new TeveFragment();
    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(teveFragment);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadTeveProgram(){
        onView(withId(R.id.recyclerviewTeve)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerviewTeve)).check(new RecyclerViewItemCountAssertion(10));
    }
}