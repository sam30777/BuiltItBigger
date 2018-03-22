package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.test.rule.ActivityTestRule;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;
import android.app.Application;
import android.text.TextUtils;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Santosh on 22-03-2018.
 */

public class SimpleAsynUnitTest extends ApplicationTestCase<Application>{
    private String jokeJaosn=null;
   private Exception joke_not_found_exception=null;
   private  CountDownLatch signal =null;
    ActivityTestRule<MainActivity> activityActivityTestRule=new ActivityTestRule<MainActivity>(MainActivity.class);
    public SimpleAsynUnitTest(Class<Application> applicationClass) {
        super(applicationClass);

    }

    @Override
    public Application getApplication() {
        return super.getApplication();
    }

    @Override
    protected void setUp() throws Exception {
        signal=new CountDownLatch(1);
        testAsync();
    }

    @Override
    protected void tearDown() throws Exception {
       signal.countDown();
    }
    @Test
    private void testAsync() throws InterruptedException{
      JokeAsynTask jokeAsynTask=new JokeAsynTask();
        jokeAsynTask.setListener(new JokeAsynTask.GetJokeListener() {
            @Override
            public void onComplete(String joke, Exception e) {
              jokeJaosn=joke;
                joke_not_found_exception=e;
                signal.countDown();
            }
        }).execute(new Pair<Context, String>(activityActivityTestRule.getActivity(),"sample joke"));
        signal.wait();
        assertNull(joke_not_found_exception);
        assertNotNull(jokeJaosn);
        assertFalse(TextUtils.isEmpty(jokeJaosn));
    }
    @Override
    public Context getSystemContext() {
        return super.getSystemContext();
    }
}
