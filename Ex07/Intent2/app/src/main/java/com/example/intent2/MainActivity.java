package com.example.intent2;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb;
    Button btnkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ EditText và Button
        edta = findViewById(R.id.txta);
        edtb = findViewById(R.id.txtb);
        btnkq = findViewById(R.id.btnketqua);

        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

            private void startActivity(Intent intent) {
            }
        });
    }
}
