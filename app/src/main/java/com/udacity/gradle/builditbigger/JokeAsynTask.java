package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.example.android.jokeandroid.JokeTellingActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Santosh on 01-01-2018.
 */

public class JokeAsynTask extends AsyncTask<Pair<Context,String>,Void,String> {
    private static MyApi myApi=null;
    private Context context;
    private String joke =null;
    private Exception exception=null;
    private GetJokeListener jokeListener;

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if(myApi==null){
            MyApi.Builder builder=new MyApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null)
                    .setRootUrl("http://192.168.65.160:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
          myApi=  builder.build();

        }

        context=pairs[0].first;
           joke=pairs[0].second;
                try {
                  return  myApi.sayHi(joke).execute().getData();
                }catch (IOException e){
                    return e.getMessage();
                }
    }
    public JokeAsynTask setListener(GetJokeListener listener) {
        this.jokeListener = listener;
        return this;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
     public interface GetJokeListener{
          void onComplete(String joke,Exception e);
     }
    @Override
    protected void onPostExecute(String s) {
         if(this.jokeListener!=null){
             this.jokeListener.onComplete(joke,exception);
         }
        Intent intent=new Intent(context, JokeTellingActivity.class);
        intent.putExtra("theJoke",s);
        context.startActivity(intent);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        if (this.jokeListener != null) {
            exception = new InterruptedException("AsyncTask cancelled");
            this.jokeListener.onComplete(null, exception);
        }
    }


}
