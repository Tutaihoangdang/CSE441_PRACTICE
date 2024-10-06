package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edta,edtkq;
    Button btnrq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edta = findViewById(R.id.edta);
        edtkq = findViewById(R.id.edtKq);
        btnrq = findViewById(R.id.btnGui);

        btnrq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai bao Intent
                Intent IT = new Intent(MainActivity.this, ResultActivity.class);
                //Dua du lieu vao Intent

                int a = Integer.parseInt(edta.getText().toString());
                IT.putExtra("soa",a);
                //Khoi dong Intent voi che do "cho ket qua tra ve"
                startActivityForResult(IT,1);  //requestcode la so bat ki

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==1){
            int kq1 = data.getIntExtra("kq",10);
            edtkq.setText(kq1+"");
        }
        if(requestCode==1&&resultCode==2){
            int kq1 = data.getIntExtra("kq",12);
            edtkq.setText(kq1+"");
        }
    }
}