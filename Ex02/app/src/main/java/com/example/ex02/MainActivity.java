package com.example.ex02;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button btncall;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "CR424 - onCreat()", Toast.LENGTH_SHORT).show();
        btncall = findViewById(R.id.btncall);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // TODO Auto-generated method stub
                Intent intent1 = new Intent(MainActivity.this, Subactivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Toast.makeText(this, "CR424 - on Destroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Toast.makeText(this, " CR424 - onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
    // TODO Auto-generated method stub
        super.onRestart();
        Toast.makeText(this, " CR424 - onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
    // TODO Auto-generated method stub

        super.onResume();
        Toast.makeText(this, " CR424 - onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
    // TODO Auto-generated method stub
        super.onStart();
        Toast.makeText(this, " CR424 - onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
    // TODO Auto-generated method stub
        super.onStop();
        Toast.makeText(this, " CR424 - onStop", Toast.LENGTH_SHORT).show();
    }
}