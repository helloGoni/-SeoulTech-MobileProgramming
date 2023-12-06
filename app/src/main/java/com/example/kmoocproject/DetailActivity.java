package com.example.kmoocproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Detail Activity"); // 액션바에 타이틀 설정
            actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로 가기 버튼 추가
        }
    }
}