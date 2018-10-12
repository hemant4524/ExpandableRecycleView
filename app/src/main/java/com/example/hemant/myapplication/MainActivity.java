package com.example.hemant.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import com.example.hemant.myapplication.adapter.MyAdapter;
import com.example.hemant.myapplication.observer.Client;
import com.example.hemant.myapplication.subject.MessageServer;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RadioButton mrbJava;
    private static boolean FLAG = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        String[] myDataset = new String[] {"A","B","C","D","E"};
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
//        observerPattern();

        mrbJava = (RadioButton)findViewById(R.id.rbJava);
        mrbJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mrbJava.setChecked(FLAG);
                FLAG = !FLAG;
            }
        });
    }


}
