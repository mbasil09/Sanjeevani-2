package com.example.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class homepage extends AppCompatActivity {
    TextView txt ;
    String curr_user;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        txt = (TextView)findViewById(R.id.welcome);
        curr_user = getIntent().getStringExtra("name");
        txt.setText(curr_user);
    }
}
