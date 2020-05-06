package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText email;
    EditText password ;
    TextView logintxt;
//    Button create ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        login = (Button) findViewById(R.id.BtnLogin);
        logintxt = findViewById(R.id.textView2);
        String Email = ((EditText) findViewById(R.id.Email)).getText().toString();
        String Password = ((EditText) findViewById(R.id.Password)).getText().toString();
    }
    public void login(View view) throws ExecutionException, InterruptedException {
        String username = email.getText().toString();
        String pswd = password.getText().toString();
        BackgroundConnector bgconnector = new BackgroundConnector(this);
        bgconnector.execute("login",username,pswd);
        String op = bgconnector.get();
        if(op.equals("failed")){
            Toast.makeText(MainActivity.this,"Unable to login",Toast.LENGTH_LONG).show();
        }
        else{
            String[] split = op.split("\\s+");
            String curr_user = split[1];
            Intent welcome = new Intent(getApplicationContext(),homepage.class);
            welcome.putExtra("name",curr_user);
            startActivity(welcome);
        }


    }
    public void register(View view){
        Intent start = new Intent(getApplicationContext(),create_user.class);
        startActivity(start);
    }
}
