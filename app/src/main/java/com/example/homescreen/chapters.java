package com.example.homescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class chapters extends AppCompatActivity {

    TextView tvc1, tvcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        tvc1 = findViewById(R.id.tvc1);
        tvcontent = findViewById(R.id.tvcontent);

        String chapnumber = getIntent().getStringExtra("Chap_number");
        String chapcontent = getIntent().getStringExtra("Chap_content");

        tvc1.setText(chapnumber);
        tvcontent.setText(chapcontent);
    }
}