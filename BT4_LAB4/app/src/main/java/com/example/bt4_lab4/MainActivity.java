package com.example.bt4_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

    Button btnread,btnwrite;
    EditText editdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnread=(Button) findViewById(R.id.btnreaddata);
        btnwrite=(Button) findViewById(R.id.btnwritedata);
        editdata=(EditText) findViewById(R.id.editdata);
        btnread.setOnClickListener(this);
        btnwrite.setOnClickListener(this);
    }
    public void onClick(View v) {
        if(v.getId()==R.id.btnreaddata)
        {
            readData();
        }
        else if(v.getId()==R.id.btnwritedata)
        {
            writeData();
        }
    }
    public void readData()
    {
        String sdcard=Environment
                .getExternalStorageDirectory()
                .getAbsolutePath()+"/myfile.txt";
        try {
            Scanner scan=new Scanner(new File(sdcard));
            StringBuilder data= new StringBuilder();
            while(scan.hasNext())
            {
                data.append(scan.nextLine()).append("\n");
            }
            scan.close();
            editdata.setText(data+"");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeData()
    {
        String sdcard=Environment
                .getExternalStorageDirectory()
                .getAbsolutePath()+"/myfile.txt";
        try {
            OutputStreamWriter writer=
                    null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                writer = new OutputStreamWriter(
                        Files.newOutputStream(Paths.get(sdcard)));
            }
            writer.write(editdata.getText()+"");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}