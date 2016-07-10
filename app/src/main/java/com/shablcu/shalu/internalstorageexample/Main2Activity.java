package com.shablcu.shalu.internalstorageexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    public static final String DEFAULT = "N/A";
    TextView usernameTextview, PasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usernameTextview = (TextView) findViewById(R.id.textViewuser);
        PasswordTextView = (TextView) findViewById(R.id.textViewpass);


    }


    public void load(View view) {

        try {
            FileInputStream fileInputStream = openFileInput("Shablcu.txt");

            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1) {
                buffer.append((char) read);
            }

            Log.d("Shablcu",buffer.toString() );

            String txtname=buffer.substring(0,buffer.indexOf(" "));
            String txtpwd=buffer.substring(buffer.indexOf(" ")+1);
            usernameTextview.setText(txtname);
            PasswordTextView.setText(txtpwd);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void previous(View view) {

        Toast.makeText(this, "previous", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
