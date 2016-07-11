package com.shablcu.shalu.externalstorage;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= (EditText) findViewById(R.id.editText_username);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }


    public void saveInternalCache(View view) {
        String data=username.getText().toString();
        File folder=getCacheDir();
        File myfile =new File(folder,"mydata1.txt");
        writeData(myfile,data);


    }

    public void saveExternalCache(View view) {

        String data=username.getText().toString();
        File folder=getExternalCacheDir();
        File myfile =new File(folder,"mydata2.txt");
        writeData(myfile, data);

    }

    public void saveExternalPublic(View view) {

        String data=username.getText().toString();
        File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myfile =new File(folder,"mydata4.txt");
        writeData(myfile, data);


    }

    public void saveExternalPrivate(View view) {

        String data=username.getText().toString();
        File folder=getExternalFilesDir("Shablcu");
        File myfile =new File(folder,"mydata3.txt");
        writeData(myfile, data);


    }

    private void writeData(File myfile ,String data){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(myfile);
            fileOutputStream.write(data.getBytes());
            message(data + "was written successfully" + myfile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null)
            {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void next(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }


    public  void message(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
