package com.example.skill5_4.movie_list;

import android.telecom.Call;
import android.util.Log;

import androidx.recyclerview.widget.SortedList;

import com.example.skill5_4.model.Movie;
import com.example.skill5_4.model.MovieListResponse;
import com.example.skill5_4.network.ApiClient;
import com.example.skill5_4.network.ApiInterface;

import java.util.List;

public class MovieListModel implements MovieListContract.Model {

    private final String TAG = "MovieListModel";
    private String API_KEY;


    /**
     * This function will fetch movies data
     * @param onFinishedListener
     * @param pageNo : Which page to load.
     */
    @Override
    public void getMovieList(final OnFinishedListener onFinishedListener, int pageNo) {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        retrofit2.Call<MovieListResponse> call = apiService.getPopularMovies(API_KEY, pageNo);
        call.enqueue(new SortedList.Callback<MovieListResponse>() {
            @Override
            public void onInserted(int position, int count) {

            }

            @Override
            public void onRemoved(int position, int count) {

            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {

            }

            @Override
            public int compare(MovieListResponse o1, MovieListResponse o2) {
                return 0;
            }

            @Override
            public void onChanged(int position, int count) {

            }

            @Override
            public boolean areContentsTheSame(MovieListResponse oldItem, MovieListResponse newItem) {
                return false;
            }

            @Override
            public boolean areItemsTheSame(MovieListResponse item1, MovieListResponse item2) {
                return false;
            }

            @Override
            public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
                onFinishedListener.onFinished(movies);
            }

            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }

}