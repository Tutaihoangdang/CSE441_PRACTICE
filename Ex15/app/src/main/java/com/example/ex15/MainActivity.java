package com.example.ex15;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMaLop, edtTenLop, edtSiSo;
    Button btnInsert, btnDelete, btnUpdate, btnQuery;
    ListView lv;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;
    SQLiteDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMaLop = findViewById(R.id.edtMaLop);
        edtTenLop = findViewById(R.id.edtTenLop);
        edtSiSo = findViewById(R.id.edtSiSo);
        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnQuery = findViewById(R.id.btnQuery);
        lv = findViewById(R.id.lv);

        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        lv.setAdapter(myAdapter);

        myDatabase = openOrCreateDatabase("QLSV.db", MODE_PRIVATE, null);

        // Create table if it does not exist
        String sql = "CREATE TABLE IF NOT EXISTS tbllop(malop TEXT primary key, tenlop TEXT, siso INTEGER)";
        myDatabase.execSQL(sql);

        btnInsert.setOnClickListener(view -> {
            String malop = edtMaLop.getText().toString();
            String tenlop = edtTenLop.getText().toString();
            int siso = Integer.parseInt(edtSiSo.getText().toString());

            ContentValues myValue = new ContentValues();
            myValue.put("malop", malop);
            myValue.put("tenlop", tenlop);
            myValue.put("siso", siso);

            String msg;
            if (myDatabase.insert("tbllop", null, myValue) == -1) {
                msg = "Fail to Insert Record!";
            } else {
                msg = "Insert record Successfully";
            }
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        btnDelete.setOnClickListener(view -> {
            String malop = edtMaLop.getText().toString();
            int n = myDatabase.delete("tbllop", "malop = ?", new String[]{malop});
            String msg = (n == 0) ? "No record to Delete" : n + " record is deleted";
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        btnUpdate.setOnClickListener(view -> {
            String malop = edtMaLop.getText().toString();
            int siso = Integer.parseInt(edtSiSo.getText().toString());

            ContentValues myValue = new ContentValues();
            myValue.put("siso", siso);

            int n = myDatabase.update("tbllop", myValue, "malop = ?", new String[]{malop});
            String msg = (n == 0) ? "No record to update" : n + " record is updated";
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        btnQuery.setOnClickListener(view -> {
            myList.clear();
            Cursor c = myDatabase.query("tbllop", null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    String data = c.getString(0) + " - " + c.getString(1) + " - " + c.getString(2);
                    myList.add(data);
                } while (c.moveToNext());
            }
            c.close();
            myAdapter.notifyDataSetChanged();
        });
    }
}