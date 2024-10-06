package com.example.intent2;

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

public class ResultActivity extends AppCompatActivity {

    TextView txtKQ ;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        txtKQ = findViewById(R.id.txtNghiem);
        btnBack = findViewById(R.id.btnBack);

        //Nhận Intent
        Intent IT02 = getIntent();
        //Lấy Bundle
        Bundle BD02 = IT02.getBundleExtra("BD1");
        // Lấyđu lieu khoi bundle
        int a = BD02.getInt("soa");
        int b = BD02.getInt("sob");

        if(a==0){
            if(b==0){
                txtKQ.setText("Phuong trinh vo so nghiem!");
            }
            else{
                txtKQ.setText("Phuong trinh vo nghiem!");
            }
        }
        else {
            double c = (-1.0)*b/a;
            txtKQ.setText(c+"");
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
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