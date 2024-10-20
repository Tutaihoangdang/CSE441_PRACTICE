package com.example.btth3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList = new ArrayList<>();
    private FloatingActionButton fabAddStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewStudents);
        fabAddStudent = findViewById(R.id.fabAddStudent);

        loadJSONData();

        studentAdapter = new StudentAdapter(studentList, this, student -> {

            Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
            intent.putExtra("student", student);
            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);

        fabAddStudent.setOnClickListener(v -> {

            new AddStudentDialog(this, studentAdapter, studentList, this).show();
        });
    }

    private void loadJSONData() {
        try {
            InputStreamReader reader = new InputStreamReader(getAssets().open("students.json"));
            Gson gson = new GsonBuilder().create();
            Type studentListType = new TypeToken<List<Student>>(){}.getType();
            Students students = gson.fromJson(reader, Students.class);
            studentList.addAll(students.students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToInternalStorage() {
        try {
            FileOutputStream fos = openFileOutput("students.json", MODE_PRIVATE);
            Gson gson = new Gson();
            String json = gson.toJson(new Students(studentList));
            fos.write(json.getBytes());
            fos.close();
            Toast.makeText(this, "Dữ liệu đã được lưu", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public interface OnStudentDeletedListener {
        void onStudentDeleted(Student student);
    }
    public void onStudentDeleted(Student student) {
        studentList.remove(student);
        studentAdapter.notifyDataSetChanged();
        saveToInternalStorage();
    }
    public void removeStudent(Student student) {
        studentList.remove(student);
        studentAdapter.notifyDataSetChanged();
        saveToInternalStorage();
    }

}
