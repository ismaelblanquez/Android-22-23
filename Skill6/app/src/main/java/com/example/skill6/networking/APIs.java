package com.example.skill6.networking;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    String BASE_URL = "https://fakerestoreapi.com/";

    @GET("products")
    Call<List<ProductResult>> getProducts();
}
