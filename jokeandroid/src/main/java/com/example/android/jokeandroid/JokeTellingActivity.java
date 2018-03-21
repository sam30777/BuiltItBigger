package com.example.android.jokeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeTellingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_telling);
        Intent intent=getIntent();
        String s=intent.getStringExtra("theJoke");
        TextView joke=(TextView)findViewById(R.id.jokeText);
        joke.setText(s);
    }
}
