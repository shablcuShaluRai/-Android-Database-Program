package com.shablcu.shalu.externalstorage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
 private EditText user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        user= (EditText) findViewById(R.id.usrtext);
    }



    public void loadInternalcache(View view){
        File folder=getCacheDir();
        File myfile=new File(folder,"Mydata1.txt");
        String data=readData(myfile);
        if (data!=null){
            user.setText(data);
        }
        else {
         user.setText("Data not Found");
        }

    }
    public void loadExternalCache(View view){

        File folder=getExternalCacheDir();
        File myfile=new File(folder,"Mydata2.txt");
        String data=readData(myfile);
        if (data!=null){
            user.setText(data);
        }
        else {
            user.setText("Data not Found");
        }


    }
    public  void loadExternalPrivate(View view){

        File folder=getExternalFilesDir("Shablcu");
        File myfile=new File(folder,"Mydata3.txt");
        String data=readData(myfile);
        if (data!=null){
            user.setText(data);
        }
        else {
            user.setText("Data not Found");
        }

    }
    public void loadExternalPublic(View view){

        File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myfile=new File(folder,"Mydata4.txt");
        String data=readData(myfile);
        if (data!=null){
            user.setText(data);
        }
        else {
            user.setText("Data not Found");
        }
    }


    public String readData( File myfile){
        FileInputStream fileInputStream=null;

        try {
            int read=-1;
            fileInputStream=new FileInputStream(myfile);
            StringBuffer stringBuffer=new StringBuffer();
            while ((read=fileInputStream.read())!=-1){
                stringBuffer.append((char)read);
            }
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public  void previous(View view){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void message(String message){

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
