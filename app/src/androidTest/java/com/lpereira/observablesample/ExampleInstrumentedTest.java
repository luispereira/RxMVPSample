package com.lpereira.observablesample;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.lpereira.observablesample.presentation.MainPresenter;
import com.lpereira.observablesample.ui.MainActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Mock MainPresenter presenter;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Mock
    private MainActivity mActivity;

    @Before
    public void init() {
        mActivity = mActivityTestRule.getActivity();
        initMocks(this);

        doNothing().when(presenter).requestConfigs();
    }

    @Test
    public void injectPresenterTest() throws Exception {
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                System.out.println("called with arguments: " + Arrays.toString(args));
                return null;
            }
        }).when(mActivity).onSuccess(Arrays.asList("0", "2"));

        ViewMatchers.withId(R.id.textExample).matches(ViewMatchers.isDisplayed());
    }
}
