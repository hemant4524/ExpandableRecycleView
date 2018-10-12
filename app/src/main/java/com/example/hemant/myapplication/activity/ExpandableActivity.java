package com.example.hemant.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hemant.myapplication.R;
import com.example.hemant.myapplication.expandable.ApiClient;
import com.example.hemant.myapplication.expandable.ApiInterface;
import com.example.hemant.myapplication.expandable.AppData;
import com.example.hemant.myapplication.expandable.ChildView;
import com.example.hemant.myapplication.expandable.Communicator;
import com.example.hemant.myapplication.expandable.HeaderView;
import com.example.hemant.myapplication.expandable.Movie;
import com.mindorks.placeholderview.ExpandablePlaceHolderView;
import com.mindorks.placeholderview.annotations.expand.Parent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpandableActivity extends AppCompatActivity implements Communicator {

    private Map<String,List<Movie>> categoryMap;

    private List<Movie> movieList;

    private ExpandablePlaceHolderView expandablePlaceHolderView;

    ChildView mChildView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        movieList = new ArrayList<>();
        categoryMap = new HashMap<>();
        expandablePlaceHolderView = (ExpandablePlaceHolderView) findViewById(R.id.expandablePlaceHolder);



        expandablePlaceHolderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Toast.makeText(ExpandableActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });
        expandablePlaceHolderView.animate();

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    private void loadData(){

        ApiInterface apiInterface = ApiClient.getInstance().create(ApiInterface.class);
        apiInterface.getAllMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieList = response.body();
                getHeaderAndChild(movieList);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });

    }

    private void getHeaderAndChild(List<Movie> movieList){

        int autoId = 1;
        for (Movie movie : movieList ){
            List<Movie> movieList1 = categoryMap.get(movie.getCategoty());
            if(movieList1 == null){
                movieList1 = new ArrayList<>();
            }
            movie.setId(autoId);
            movieList1.add(movie);
            categoryMap.put(movie.getCategoty(),movieList1);
            autoId ++;
        }

        Log.d("Map",categoryMap.toString());
        Iterator it = categoryMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Log.d("Key", pair.getKey().toString());
            expandablePlaceHolderView.addView(new HeaderView(this, pair.getKey().toString()));
            List<Movie> movieList1 = (List<Movie>) pair.getValue();
            for (Movie movie : movieList1){
                expandablePlaceHolderView.addView(new ChildView(this, movie,this));
            }
            it.remove();
        }
        expandablePlaceHolderView.expand(1);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        String list = AppData.getInstance().getMovie().toString();
        Log.d("AppData:", "onBackPressed: "+list);
        super.onBackPressed();
    }


    @Override
    public void getMovie(Movie movie) {
        String movieName = movie.getName();
        Toast.makeText(this, movieName, Toast.LENGTH_SHORT).show();
    }
}