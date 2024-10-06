package com.example.intent2;

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

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb;
    Button btnKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        btnKq = findViewById(R.id.btnkq);

        btnKq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ITKQ = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());

                //Đóng gói dữ liệu trong Bundle
                Bundle BD1 = new Bundle();
                BD1.putInt("soa",a);
                BD1.putInt("sob",b);

                //Đưa Bundle vào Intent
                ITKQ.putExtra("BD1",BD1);
                //Khởi động Intent;
                startActivity(ITKQ);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}