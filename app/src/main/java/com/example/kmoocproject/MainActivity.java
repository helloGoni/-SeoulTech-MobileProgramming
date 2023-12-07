package com.example.kmoocproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    static RequestQueue requestQueue;
    RecyclerView recyclerView;
    ResultAdapter adapter;

    int pageNum = 1;

    Toolbar toolbar;
    Example example;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //adapter = new ResultAdapter();
        recyclerView.setAdapter(adapter);

        makeRequest(pageNum);

        toolbar = findViewById(R.id.toolbar);

        Button nextBtn, prevBtn;
        nextBtn = findViewById(R.id.nextBtn);
        prevBtn = findViewById(R.id.prevBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pageNum;
                makeRequest(pageNum);
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pageNum != 1) {
                    --pageNum;
                    makeRequest(pageNum);
                }
            }
        });


    }
    /* 인증키
    l9L%2FQpQyMGS8NHn7URnUoHUInW51PZ8MqHs6aVaUoOxMfd%2FnukOJCiJjwTEMzyaGJtJwoWurugTGiCon40Yrqw%3D%3D

     */

    public void makeRequest(int num) {
        String temp = Integer.toString(num);
        String url = "http://apis.data.go.kr/B552881/kmooc/" +
                "courseList?ServiceKey=l9L%2FQpQyMGS8NHn7URnUoHUInW51PZ8MqHs6aVaUoOxMfd%" +
                "2FnukOJCiJjwTEMzyaGJtJwoWurugTGiCon40Yrqw%3D%3D&page=0" +
                temp;

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                response -> {  println("일단성공");
                    processResponse(response); },
                error -> {
                    println("에러 : "+error.getMessage());
                    error.printStackTrace();
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> headers = super.getHeaders();
                if (headers == null || headers.isEmpty()) {
                    headers = new HashMap<>();
                }
                headers.put("Content-Type", "application/json; charset=UTF-8");
                return headers;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }

    public void println(String log) {Log.d("MainActivity",log);}

    public void processResponse(String response) {

        Gson gson = new Gson();
        example = gson.fromJson(response, Example.class);

        ArrayList<Result> resultList = example.getResults();

        if(resultList.get(0).getName() == null)
            Log.d("DetailActivity", "다운에서부터 안대나");
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ResultAdapter(resultList);
        recyclerView.setAdapter(adapter);
    }
}