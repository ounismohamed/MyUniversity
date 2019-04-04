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

    private List<Person> persons;
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

      /*
                initializeData();

   */


/*

                for (Case case:cases){
                    String content="";
                    content+="ID: "+case.getId()+"\n";
                    content+="USER-ID: "+case.getUserId()+"\n";
                    content+="Title: "+case.getTitle()+"\n";
                    content+="Text: "+case.getText()+"\n\n";

                    textViewResult.append(content);

                }*/
            }

            @Override
            public void onFailure(Call<List<Case>> call, Throwable t) {
  //              textViewResult.setText(t.getMessage());
            }
        });










    }


  String response= " [{\"app_uid\": \"50576446953235bfb797531078087088\",\"del_index\": \"1\",\"del_last_index\": \"1\",\"app_number\": \"1\",\"app_status\": \"ID_DRAFT\",\"usr_uid\": \"00000000000000000000000000000001\"\"previous_usr_uid\": \"\",\"tas_uid\": \"7983935495320c1a75e1df6068322280\",\"pro_uid\"    }]";

/*    private void initializeData(){
        cases = new ArrayList<>();
        cases.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        cases.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        cases.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
        cases.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        cases.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        cases.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
        cases.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        cases.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        cases.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
        cases.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        cases.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        cases.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
        cases.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        cases.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        cases.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
    }*/
    private void initializeAdapter(List<Case> cases){
        RVAdapter adapter = new RVAdapter(cases);
        rv.setAdapter(adapter);
    }
}
