package com.example.spinner;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo Spinner và TextView
    Spinner spinner;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ Spinner và TextView
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);

        // Dữ liệu cho Spinner
        String[] categories = {"Hàng điện tử", "Hàng hóa chất", "Hàng gia dụng"};

        // Tạo ArrayAdapter cho Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Gán Adapter vào Spinner
        spinner.setAdapter(adapter);

        // Xử lý khi chọn một mục trong Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Cập nhật TextView khi một mục được chọn
                textView.setText("Bạn đã chọn: " + categories[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không làm gì khi không có mục nào được chọn
            }
        });
    }
}
