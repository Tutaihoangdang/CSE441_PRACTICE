package com.example.ex16;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB;
    private TextView edtKQ;
    private Button btnTong, btnClear;
    private TextView txtLichSu;
    private StringBuilder lichSu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnTong = findViewById(R.id.btnTong);
        btnClear = findViewById(R.id.btnClear);
        txtLichSu = findViewById(R.id.txtLichSu);

        lichSu = new StringBuilder();  // Dùng để lưu lịch sử phép tính

        // Xử lý khi nhấn nút "Tổng"
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();
            }
        });

        // Xử lý khi nhấn nút "Clear"
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });
    }

    // Hàm tính tổng và hiển thị kết quả
    private void calculateSum() {
        String valueA = edtA.getText().toString();
        String valueB = edtB.getText().toString();

        if (TextUtils.isEmpty(valueA) || TextUtils.isEmpty(valueB)) {
            edtKQ.setText("Vui lòng nhập đủ số");
            return;
        }

        // Chuyển đổi giá trị nhập thành số nguyên
        int a = Integer.parseInt(valueA);
        int b = Integer.parseInt(valueB);
        int sum = a + b;

        // Hiển thị kết quả tổng
        edtKQ.setText(String.valueOf(sum));

        // Lưu lịch sử phép tính
        lichSu.append(a).append(" + ").append(b).append(" = ").append(sum).append("\n");
        txtLichSu.setText(lichSu.toString());
    }

    // Hàm để xóa dữ liệu nhập và kết quả
    private void clearInputs() {
        edtA.setText("");
        edtB.setText("");
        edtKQ.setText("");
    }
}
