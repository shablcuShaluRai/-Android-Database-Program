package com.shablcu.shalu.sharedpreferenceexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView usernameTextview, PasswordTextView;
    public static final String DEFAULT="N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usernameTextview = (TextView) findViewById(R.id.textViewuser);
        PasswordTextView = (TextView) findViewById(R.id.textViewpass);


    }


    public  void load(View view){

        SharedPreferences sharedPreferences=getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("Name", DEFAULT);
        String password=sharedPreferences.getString("Password", DEFAULT);
        if(name.equals(DEFAULT)||password.equals(DEFAULT)){
            Toast.makeText(this,"No Data Found",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Data Loaded Successfully",Toast.LENGTH_LONG).show();
            usernameTextview.setText(name);
            PasswordTextView.setText(password);
        }

    }

    public void previous(View view){

        Toast.makeText(this,"previous",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }


}
