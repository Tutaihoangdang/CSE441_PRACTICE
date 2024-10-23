package com.example.ex14_02;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edttim;
    ListView lv1, lv2, lv3;
    TabHost tab;
    ArrayList<Item> list1;
    ArrayList<Item> list2;
    ArrayList<Item> list3;
    com.example.ex14_02.MyArrayAdapter myArray1, myArray2, myArray3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addContentView();
        addEvent();
    }

    private void addContentView() {
    }

    private void addEvent() {
        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("t1")) {
                    list1.clear();
                    list1.add(new Item("52300", "Em là ai Tôi là ai", 0));
                    list1.add(new Item("52600", "Chén Đắng", 1));
                    myArray1.notifyDataSetChanged();
                }
                if (tabId.equalsIgnoreCase("t2")) {
                    list2.clear();
                    list2.add(new Item("57236", "Anh yeeu em ", 0));
                    list2.add(new Item("51548", "Anh yeu em rat nhieu", 0));
                    myArray2.notifyDataSetChanged();
                }
                if (tabId.equalsIgnoreCase("t3")) {
                    list3.clear();
                    list3.add(new Item("57689", "Don gian anh yeu em", 1));
                    list3.add(new Item("58716", "Anh chiu em roi", 0));
                    myArray3.notifyDataSetChanged();
                }
            }
        });
    }
}