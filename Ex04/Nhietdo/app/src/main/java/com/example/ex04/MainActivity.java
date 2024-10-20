package com.example.ex04;

import com.example.ex04.R;  // This import should remain

import android.annotation.SuppressLint;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText txtFar, txtCel;
    Button btnCel, btnFar, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFar = findViewById(R.id.txtCel);
        txtCel = findViewById(R.id.txtFar);
        btnFar = findViewById(R.id.btnFar);
        btnCel = findViewById(R.id.btnCel);
        btnClear = findViewById(R.id.btnClear);

        btnFar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doC = txtFar.getText().toString();
                int C = Integer.parseInt(doC);
                txtCel.setText("" + dcf.format(C * 1.8 + 32));
            }
        });

        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                // TODO Auto-generated method stub
                String doF = txtCel.getText().toString();
                int F = Integer.parseInt(doF);
                txtFar.setText("" + dcf.format((F - 32) / 1.8));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCel.setText("");  // Xóa nội dung của txtCel
                txtFar.setText("");  // Xóa nội dung của txtFar
            }
        });
    }
}
