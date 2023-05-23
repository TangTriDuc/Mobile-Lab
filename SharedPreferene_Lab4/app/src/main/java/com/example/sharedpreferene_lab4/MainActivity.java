package com.example.sharedpreferene_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edit1);
        age = findViewById(R.id.edit2);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getPreferences(Context.MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        int a = sh.getInt("age", 0);
        name.setText(s1);
        age.setText(String.valueOf(a));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sh = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sh.edit();
        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        myEdit.apply();
    }


}