package com.example.skill5_5;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieListViewModel {


    //This class is used for VIEWMODEL

    private MovieRepository movieRepository;

    //constructor
    public MovieListViewModel(){
        movieRepository = MovieRepository.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies(){ return movieRepository.getMovies();}

    //3- Calling method in view Model
    public void searchMovieApi(String query, int pageNumber){
        movieRepository.searchMovieApi(query,pageNumber);
    }

}
