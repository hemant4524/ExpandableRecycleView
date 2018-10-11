package com.example.hemant.myapplication.expandable;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
  @GET("movielist.json")
  Call<List<Movie>> getAllMovies();
}
