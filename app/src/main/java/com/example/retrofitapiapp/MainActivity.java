package com.example.retrofitapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitapiapp.model.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    static String url ="https://jsonplaceholder.typicode.com/";
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        tv.setText("");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi api = retrofit.create(myApi.class);
        Call<List<model>> call = api.getModels();

        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> list = response.body();
                for (int i=0; i<list.size(); i++){
                    tv.append("No. "+list.get(i).getId() +"\nTitle : "+ list.get(i).getTitle()+ "\n\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {

            }
        });


    }
}