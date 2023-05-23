package com.example.bt1_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

   EditText editdata;
    Button btn;

    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editdata = (EditText) findViewById(R.id.editdata);

        btn = (Button) findViewById(R.id.btnreaddata);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data;
                InputStream inputStream = getResources().openRawResource(R.raw.myfile);
                try {
                    byte[] buffer = new byte[inputStream.available()];
                    while (inputStream.read(buffer) != -1)
                        txt = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                editdata.setText(txt);

            }

        });
    }
}
