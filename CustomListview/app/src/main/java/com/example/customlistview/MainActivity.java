package com.example.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Đặt mảng image bên trong lớp, nhưng ngoài các phương thức
    int image[] = {R.drawable.anhta1, R.drawable.anhta2, R.drawable.anhta3, R.drawable.anhta4 };

    String name[] ={"ảnh 1", "ảnh 2", "ảnh 3", "ảnh 4"};

    //Khai báo mảng chính để lấy dữ liệu từ hai mảng phụ
    ArrayList<Phone> myList ;
    MyArrayAdapter myAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();

        for(int i=0;i<name.length;i++){
            myList.add(new Phone(image[i],name[i]));

        }
        myAdapter = new MyArrayAdapter(MainActivity.this,R.layout.layoutitem,myList);
        lv.setAdapter(myAdapter);

        //Sử lí Click

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myintent = new Intent(MainActivity.this, SubActivity.class);
                myintent.putExtra("name",name[i]);
                startActivity(myintent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
