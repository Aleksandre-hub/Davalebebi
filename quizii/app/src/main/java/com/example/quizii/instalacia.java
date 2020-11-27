package com.example.quizii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class instalacia extends AppCompatActivity {

    public void finish (View view)
    {
        finish();
    }

    public void link (View view)
    {
        Intent linki = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
        startActivity(linki);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instalacia);
    }
}