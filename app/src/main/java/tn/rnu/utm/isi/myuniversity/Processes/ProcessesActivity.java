package tn.rnu.utm.isi.myuniversity.Processes;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tn.rnu.utm.isi.myuniversity.Oauth2.JsonPlaceHolderAPI;
import tn.rnu.utm.isi.myuniversity.R;


public class ProcessesActivity extends Activity {


    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        String token = getIntent().getStringExtra("Token");
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        Call<List<Case>> call = jsonPlaceHolderAPI.getUser("Bearer "+token);
        call.enqueue(new Callback<List<Case>>() {
            @Override
            public void onResponse(Call<List<Case>> call, Response<List<Case>> response) {

                if (!response.isSuccessful()){
                    Toast.makeText(ProcessesActivity.this, "Code : "+ response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Case> cases = response.body();

                initializeAdapter(cases);


            }

            @Override
            public void onFailure(Call<List<Case>> call, Throwable t) {
            }
        });
    }


    private void initializeAdapter(List<Case> cases){
        RVAdapter adapter = new RVAdapter(cases);
        rv.setAdapter(adapter);
    }
}
