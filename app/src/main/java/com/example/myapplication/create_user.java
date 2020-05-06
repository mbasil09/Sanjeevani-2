package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class create_user extends AppCompatActivity {
    Switch donor;
    Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }
    public void register(View view) throws ExecutionException, InterruptedException {
        String name = ((EditText) findViewById(R.id.create_name)).getText().toString();
        String address = ((EditText) findViewById(R.id.create_address)).getText().toString();
        String contact = ((EditText) findViewById(R.id.create_number)).getText().toString();
        String email = ((EditText) findViewById(R.id.create_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.create_pass)).getText().toString();
        String age = ((EditText) findViewById(R.id.create_age)).getText().toString();
        String sex = ((EditText) findViewById(R.id.create_sex)).getText().toString();
        donor = (Switch) findViewById(R.id.create_switch);
        Boolean donor_switch = donor.isChecked();

        BackgroundConnector bgconnector = new BackgroundConnector(this);
        bgconnector.execute("register",name,address,contact,email,password,age,sex,donor_switch.toString());
//        String op = bgconnector.get();
//        if (op.equals("already registered")){
//            Toast.makeText(create_user.this,"Already registered with this email",Toast.LENGTH_LONG).show();
//        }
//        else if (op.equals("failed")){
//            Toast.makeText(create_user.this,"failed",Toast.LENGTH_LONG).show();
//        }
//        else if (op.equals("success")){
//            Toast.makeText(create_user.this,"success",Toast.LENGTH_LONG).show();
//            Intent login = new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(login);
//        }
    }
}
