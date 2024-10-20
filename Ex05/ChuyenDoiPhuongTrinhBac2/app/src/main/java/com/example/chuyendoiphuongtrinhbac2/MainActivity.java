package com.example.chuyendoiphuongtrinhbac2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends Activity {
    // Khai báo các biến tương ứng với các view trong giao diện
    Button btnTieptuc, btnGiai, btnThoat;
    EditText edita, editb, editc;
    TextView txtkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view trong giao diện với các biến
        btnTieptuc = findViewById(R.id.btntieptuc);
        btnGiai = findViewById(R.id.btngiaipt);
        btnThoat = findViewById(R.id.btnthoat);
        edita = findViewById(R.id.edta);
        editb = findViewById(R.id.edtb);
        editc = findViewById(R.id.edtc);
        txtkq = findViewById(R.id.txtkq);

        // Xử lý khi nhấn nút "Giải"
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các EditText
                String sa = edita.getText().toString();
                String sb = editb.getText().toString();
                String sc = editc.getText().toString();

                // Kiểm tra nếu các trường dữ liệu rỗng
                if (sa.isEmpty() || sb.isEmpty() || sc.isEmpty()) {
                    txtkq.setText("Vui lòng nhập đủ thông tin!");
                    return;
                }

                // Chuyển đổi dữ liệu từ String sang số nguyên
                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);

                // Khai báo biến kết quả
                String kq = "";
                DecimalFormat dcf = new DecimalFormat("0.00");

                // Giải phương trình bậc 2
                if (a == 0) {
                    if (b == 0) {
                        if (c == 0)
                            kq = "Phương trình vô số nghiệm";
                        else
                            kq = "Phương trình vô nghiệm";
                    } else {
                        kq = "Phương trình có 1 nghiệm, x = " + dcf.format(-c / (double) b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        kq = "Phương trình vô nghiệm";
                    } else if (delta == 0) {
                        kq = "Phương trình có nghiệm kép x1 = x2 = " + dcf.format(-b / (2.0 * a));
                    } else {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        kq = "Phương trình có 2 nghiệm: x1 = " + dcf.format(x1) + ", x2 = " + dcf.format(x2);
                    }
                }

                // Hiển thị kết quả ra TextView
                txtkq.setText(kq);
            }
        });

        // Xử lý khi nhấn nút "Tiếp tục" (reset các trường nhập liệu)
        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa dữ liệu trong các EditText và đưa con trỏ về edita
                edita.setText("");
                editb.setText("");
                editc.setText("");
                txtkq.setText("");  // Xóa kết quả cũ
                edita.requestFocus();
            }
        });

        // Xử lý khi nhấn nút "Thoát" (thoát ứng dụng)
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kết thúc activity
                finish();
            }
        });
    }
}
