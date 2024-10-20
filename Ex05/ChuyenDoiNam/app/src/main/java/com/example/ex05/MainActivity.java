package com.example.ex05;

import static com.example.ex05.R.id.textViewKetQua;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editNamDuongLich;
    Button buttonChuyenDoi;
    TextView textViewKetQua;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editNamDuongLich = findViewById(R.id.editnamduonglich);
        buttonChuyenDoi = findViewById(R.id.button1);
        textViewKetQua = findViewById(R.id.textViewKetQua);

        // Set button click listener
        buttonChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namDuongStr = editNamDuongLich.getText().toString();

                if (!namDuongStr.isEmpty()) {
                    int namDuong = Integer.parseInt(namDuongStr);
                    String namAm = convertNamDuongToNamAm(namDuong);
                    textViewKetQua.setText(namAm);
                } else {
                    textViewKetQua.setText("Vui lòng nhập năm dương lịch.");
                }
            }
        });
    }

    private String convertNamDuongToNamAm(int namDuong) {
        String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
        String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

        // Determine Can and Chi
        String canValue = can[namDuong % 10];
        String chiValue = chi[namDuong % 12];

        return canValue + " " + chiValue;
    }
}