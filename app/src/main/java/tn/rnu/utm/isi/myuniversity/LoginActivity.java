package tn.rnu.utm.isi.myuniversity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;

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

        result_tv = (TextView) findViewById(R.id.result);

        valider_btn = (Button) findViewById(R.id.valider);

        valider_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String login = "mohamed";
                String password="123";

                // TODO Oauth2.0 authentication module
                 if (login.equals(login_et.getText().toString()) && password.equals(password_et.getText().toString()))
                {






                    // TODO Redirect to Account choices
                    result_tv.setText(" Succeded ");
                    start_processes(v);

                }
                        //TODO Print ERROR MSG  FROM O-AUTH
                else {result_tv.setText(" Failed ");}

            }
        });

    }

public void start_processes (View v){
        Intent i = new Intent(this,ProcessesActivity.class);
        // TODO putextra
        startActivity(i);

    }

}