package com.shablcu.shalu.sqliteexample3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatabaseAdapter databaseHelper;
    EditText userName, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.editText_username);
        Password = (EditText) findViewById(R.id.editText_password);

        databaseHelper = new DatabaseAdapter(this);
    }


    public void addUser(View view) {
        String user = userName.getText().toString();
        String pass = Password.getText().toString();


        long id = databaseHelper.insertData(user, pass);

        if (id < 0) {
            Message.message(this, "Data not inserted");
        } else {
            Message.message(this, "Data inserted");
        }

    }

    public void viewDetail(View view){

        String data=databaseHelper.getAllData();
        Message.message(this,data);

    }

}
