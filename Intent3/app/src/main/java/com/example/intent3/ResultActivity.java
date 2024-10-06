package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    EditText edtdlnhan;
    Button btnGoc, btnBinhphuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        edtdlnhan = findViewById(R.id.edtDlnhan);
        btnGoc = findViewById(R.id.btnGoc);
        btnBinhphuong = findViewById(R.id.btnBinhphuong);

        //Nhan intent
        Intent IT2 = getIntent();
        // Lay du lieu khoi Intent

        int a = IT2.getIntExtra("soa",0); //defaul value se set gia tri mac dinh khi lay khong duoc
        edtdlnhan.setText(a + "");

        btnGoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IT2.putExtra("kq",a);
                setResult(1,IT2);
                finish();
            }
        });

        btnBinhphuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IT2.putExtra("kq",a*a);
                setResult(2,IT2);
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