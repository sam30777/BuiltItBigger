package com.example.android.jokeandroid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Santosh on 21-03-2018.
 */
@RunWith(AndroidJUnit4.class)
public class SimpleUnitTest {
    private Boolean isConnected;
    @Rule
    public ActivityTestRule<JokeTellingActivity> activityTest = new ActivityTestRule<>(JokeTellingActivity.class);

    @Before
    public void CheckInternet() {
        isConnected = CheckConnection(activityTest.getActivity());

    }

    private static boolean CheckConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) return true;
        return false;
    }

    @Test
    public void TestFunction() {
        assertTrue(isConnected);
        if (isConnected) {
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
                    assertNotNull(R.id.jokeText);

                    onView(withId(R.id.jokeText)).check(matches(not(withText(""))));
                }
            };


        }
    }
}