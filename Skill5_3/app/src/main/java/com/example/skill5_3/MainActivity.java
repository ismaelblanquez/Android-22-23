package com.example.skill5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.skill5_3.contract.JsonPlaceHolderApi;
import com.example.skill5_3.model.Model;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView mJsonTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJsonTxtView.findViewById(R.id.jsonText);
    }
    private void getPosts(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Model>> call = jsonPlaceHolderApi.getPost();
        call.enqueue(new Callback<List<Model>>(){


            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo: " + response.code());
                    return;
                }
                List<Model> postsLists = response.body();

                for(Model model: postsLists){
                    String content = "";
                    content+= "userId:" + model.getUserid() + "\n";
                    content+= "id:" + model.getId() + "\n";
                    content+= "title:" + model.getTitle() + "\n";
                    content+= "body:" + model.getBody() + "\n";
                    mJsonTxtView.append(content);

                }
            }

            @Override
            public void onFailure(Call<List< Model >> call, Throwable t){
                mJsonTxtView.setText(t.getMessage());
            }
        });

    }
}