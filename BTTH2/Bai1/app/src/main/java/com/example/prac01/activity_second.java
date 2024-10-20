package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_second extends AppCompatActivity {
    TextView edthoten, edtdtb;
    Button btnstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        edthoten = findViewById(R.id.edthoten);
        edtdtb = findViewById(R.id.edtdtb);
        btnstart = findViewById(R.id.btnstart);

        Intent myintent = getIntent();
        Bundle mybundle = myintent.getBundleExtra("mypackage");
        String a = mybundle.getString("ten");
        int b = mybundle.getInt("diem");

        edthoten.setText(""+ a);
        edtdtb.setText(String.valueOf(""+ b));

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}