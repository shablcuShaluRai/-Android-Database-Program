package com.shablcu.shalu.sharedpreferenceexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        SharedPreferences sharedPreferences = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", username.getText().toString());
        editor.putString("Password", Password.getText().toString());
        editor.commit();

        Toast.makeText(this, "Data saves successfully", Toast.LENGTH_SHORT).show();
    }

    public void next(View view) {

        Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);


    }
}
