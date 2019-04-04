package tn.rnu.utm.isi.myuniversity.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tn.rnu.utm.isi.myuniversity.Oauth2.JsonPlaceHolderAPI;
import tn.rnu.utm.isi.myuniversity.Oauth2.TokenRequest;
import tn.rnu.utm.isi.myuniversity.Oauth2.TokenResponse;
import tn.rnu.utm.isi.myuniversity.Processes.ProcessesActivity;
import tn.rnu.utm.isi.myuniversity.R;

public class LoginActivity extends AppCompatActivity {


    EditText login_et, password_et;
    TextView result_tv;

    Button valider_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_et = (EditText) findViewById(R.id.login);
        password_et = (EditText) findViewById(R.id.password);

        valider_btn = (Button) findViewById(R.id.valider);

        valider_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username= new String(login_et.getText().toString());

                String password= new String(password_et.getText().toString());

                TokenRequest tokenRequest = new TokenRequest("password","*","SJGZDWXOPLJZLBDQGACCAGAVWSHORHJK","6734914665b5258c7a2eb01077382585",username,password);
                sendNetworkRequest(tokenRequest,v);
            }
        });

    }
    private void sendNetworkRequest(TokenRequest tokenRequest, final View v){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://process.isiforge.tn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI_for_auth = retrofit.create(JsonPlaceHolderAPI.class);

        Call<TokenResponse> call = jsonPlaceHolderAPI_for_auth.getToken(tokenRequest);
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {

                if (response.body()!=null) {
                    Toast.makeText(LoginActivity.this, " Success Token" + response.body().getAccess_token(), Toast.LENGTH_SHORT).show();
                    start_processes(v);
                }
                else
                { Toast.makeText(LoginActivity.this, "Something went wrong <authentication error>", Toast.LENGTH_SHORT).show();}
                }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Something went wrong <connection error>", Toast.LENGTH_SHORT).show();
            }
        });


    }

public void start_processes (View v){
        Intent i = new Intent(this, ProcessesActivity.class);
        // TODO putextra
        startActivity(i);

    }

}