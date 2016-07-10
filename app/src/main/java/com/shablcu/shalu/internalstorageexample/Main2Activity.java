package com.shablcu.shalu.internalstorageexample;

import android.content.Intent;
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

       
    }

    public void previous(View view){

        Toast.makeText(this,"previous",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }


}
