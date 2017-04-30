package com.example.recyclerview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    RecyclerView rv;
    RvAdapter adapter;
    List<Data> dataList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.rv);

        adapter=new RvAdapter(dataList);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);

        prepareData();

    }

    void prepareData()
    {
        dataList.add(new Data("HDFC","ABC Mutual funds","3500",R.drawable.ic_action_name, Color.RED));
        dataList.add(new Data("SBI","XYZ Mutual funds","5000",R.drawable.ic_action_name, Color.BLUE));
        dataList.add(new Data("ICICI","PQR Mutual funds","1500",R.drawable.ic_action_name, Color.BLACK));
        dataList.add(new Data("ICICI","PQR Mutual funds","1500",R.drawable.ic_action_name, Color.YELLOW));
        dataList.add(new Data("ICICI","PQR Mutual funds","1500",R.drawable.ic_action_name, Color.MAGENTA));
        dataList.add(new Data("ICICI","PQR Mutual funds","1500",R.drawable.ic_action_name, Color.GREEN));
        dataList.add(new Data("ICICI","PQR Mutual funds","1500",R.drawable.ic_action_name, Color.BLACK));


        adapter.notifyDataSetChanged();
    }
}
