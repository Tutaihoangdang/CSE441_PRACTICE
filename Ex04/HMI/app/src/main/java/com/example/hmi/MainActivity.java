package com.example.hmi;

import android.icu.text.DecimalFormat;
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
    Button btnChandoan;
    EditText editTen,editChieucao,editCannang,editBMI,editChandoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChandoan= findViewById(R.id.btnBMI);
        editTen=findViewById(R.id.edtten);
        editChieucao= findViewById(R.id.edtchieucao);
        editCannang= findViewById(R.id.edtcannang);
        editBMI= findViewById(R.id.edtBMI);
        editChandoan= findViewById(R.id.edtChuanDoan);
        btnChandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editChieucao.getText().toString().isEmpty() || editCannang.getText().toString().isEmpty()) {
                    editBMI.setText("Vui lòng nhập đủ chiều cao và cân nặng");
                    editChandoan.setText("");
                    return;
                }

                try {

                    double H = Double.parseDouble(editChieucao.getText().toString()) / 100;
                    double W = Double.parseDouble(editCannang.getText().toString());


                    double BMI = W / Math.pow(H, 2);
                    String chandoan = "";

                    if (BMI < 18) {
                        chandoan = "Bạn gầy";
                    } else if (BMI <= 24.9) {
                        chandoan = "Bạn bình thường";
                    } else if (BMI <= 29.9) {
                        chandoan = "Bạn béo phì độ 1";
                    } else if (BMI <= 34.9) {
                        chandoan = "Bạn béo phì độ 2";
                    } else {
                        chandoan = "Bạn béo phì độ 3";
                    }
                    DecimalFormat dcf = new DecimalFormat("#.0");
                    editBMI.setText(dcf.format(BMI));
                    editChandoan.setText(chandoan);
                } catch (NumberFormatException e) {
                    editBMI.setText("Dữ liệu nhập không hợp lệ");
                    editChandoan.setText("");
                }
            }
        });
    }
}