package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtsl;
    ListView lv1;
    String myphone[]= {"điện thoại Samsung","Điện thoại Iphone","Điện thoại Oppo","Điệm thoại Nokia"};
    ArrayAdapter<String> myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Ánh xạ ID

        txtsl = findViewById(R.id.txtsl);
        lv1 = findViewById(R.id.lv1);
        // Chođữ liệu vào Adapter
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,myphone);
        //Đưa dữ lệu adapder vào LV

        lv1.setAdapter(myadapter);

        //Bắt sự kện Click
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtsl.setText("Vị trí: " +i+ "  "+myphone[i]);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}