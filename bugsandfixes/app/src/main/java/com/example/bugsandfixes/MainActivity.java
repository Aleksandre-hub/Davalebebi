package com.example.bugsandfixes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void install (View view)
    {
        Button instali = (Button) findViewById(R.id.install);
        Intent instalaciaintent = new Intent(this, instalacia.class);
        startActivity(instalaciaintent);
    }

    public void problemebi (View view)
    {
       Intent fixebiii = new Intent(this, fixebi.class);
       startActivity(fixebiii);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}