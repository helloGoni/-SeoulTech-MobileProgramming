package com.example.kmoocproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import android.net.Uri;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Detail Activity");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String[] urlHolder = new String[1];

        TextView nameTextView, shortTextView, dateTextView, urlTextView;

        nameTextView = findViewById(R.id.nameTextView);
        shortTextView = findViewById(R.id.shortTextView);
        dateTextView = findViewById(R.id.dateTextView);
        urlTextView = findViewById(R.id.urlTextView);

        urlTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (urlHolder[0] != null && !urlHolder[0].isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(urlHolder[0]));
                    startActivity(intent);
                }
            }
        });

        try {
            nameTextView.setText(new String(intent.getStringExtra("lecName").getBytes("ISO-8859-1"), "UTF-8"));
            shortTextView.setText(new String(intent.getStringExtra("lecShort").getBytes("ISO-8859-1"), "UTF-8"));
            dateTextView.setText(new String(intent.getStringExtra("lecDate").getBytes("ISO-8859-1"), "UTF-8"));
            urlTextView.setText(intent.getStringExtra("lecURL"));
            urlHolder[0] = intent.getStringExtra("lecURL");
            //urlTextView.setText(new String(intent.getStringExtra("lecURL").getBytes("ISO-8859-1"), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}