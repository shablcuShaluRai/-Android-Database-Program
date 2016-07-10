package com.shablcu.shalu.internalstorageexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText username, Password;
    Button btnsave, btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editText_user);
        Password = (EditText) findViewById(R.id.editText_pwd);
        btnsave = (Button) findViewById(R.id.button_save);
        btnnext = (Button) findViewById(R.id.button_next);

    }

    public void save(View view) {
        String textname=username.getText().toString();
        String textpassword=Password.getText().toString();

        FileOutputStream fileOutputStream = null;
         textname=textname+" ";
        File file = null;


        try {

           file=getFilesDir();
           fileOutputStream= openFileOutput("Shablcu.txt", Context.MODE_PRIVATE);

            fileOutputStream.write(textname.getBytes());
            fileOutputStream.write(textpassword.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("Shablcu", e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Toast.makeText(this, "Data saved successfully "+file+"/Shablcu.txt", Toast.LENGTH_SHORT).show();
    }

    public void next(View view) {

        Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);


    }
}
