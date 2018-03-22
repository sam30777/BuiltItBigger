package com.example.android.jokeandroid;

import android.os.AsyncTask;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by Santosh on 21-03-2018.
 */
@RunWith(AndroidJUnit4.class)
public class SimpleUnitTest {
    @Rule
    public ActivityTestRule<JokeTellingActivity> activityTest = new ActivityTestRule<>(JokeTellingActivity.class);


    @Test
    public void TestFunction() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                onView(withId(R.id.jokeText)).perform(click());
                onView(withId(R.id.jokeText)).check(matches(not(withText(""))));
            }
        };


    }
}
