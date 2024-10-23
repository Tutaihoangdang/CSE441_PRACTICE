package com.example.ghichu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến
    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapter;
    EditText edtwork, edth, edtm;
    TextView txtdate;
    Button btnwork;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        edth = findViewById(R.id.edthour);
        edtm = findViewById(R.id.edtmi);
        edtwork = findViewById(R.id.edtwork);
        btnwork = findViewById(R.id.btnadd);
        lv = findViewById(R.id.listView1);
        txtdate = findViewById(R.id.txtdate);

        // Khai báo mảng ArrayList kiểu String rỗng
        arraywork = new ArrayList<>();

        // Khai báo ArrayAdapter, đưa mảng dữ liệu vào ArrayAdapter
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);

        // Đưa Adapter có dữ liệu lên ListView
        lv.setAdapter(arrAdapter);

        // Lấy ngày giờ hệ thống
        Date currentDate = Calendar.getInstance().getTime();

        // Format theo định dạng dd/MM/yyyy
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Hiển thị ngày hiện tại lên TextView
        txtdate.setText("Hôm Nay: " + simpleDateFormat.format(currentDate));

        // Xử lý sự kiện khi click vào nút "Add Work"
        btnwork.setOnClickListener(v -> {
            // Nếu 1 trong 3 EditText không có nội dung thì hiện thông báo
            if (edtwork.getText().toString().equals("") || edth.getText().toString().equals("") || edtm.getText().toString().equals("")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thiếu thông tin");
                builder.setMessage("Vui lòng nhập đầy đủ thông tin công việc");
                builder.setPositiveButton("Tiếp tục", (dialog, which) -> {
                    // Người dùng ấn tiếp tục
                });
                builder.show();
            } else {
                // Lấy nội dung công việc và thời gian từ EditText và đưa vào mảng arraywork
                String str = edtwork.getText().toString() + " - " + edth.getText().toString() + ":" + edtm.getText().toString();

                // Thêm dữ liệu vào mảng
                arraywork.add(str);

                // Cập nhật lại Adapter
                arrAdapter.notifyDataSetChanged();

                // Xóa dữ liệu sau khi thêm thành công
                edth.setText("");
                edtm.setText("");
                edtwork.setText("");
            }
        });
    }
}