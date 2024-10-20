package com.example.prac02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private StaffViewModel staffViewModel;
    EditText edtID, edtName, edtDoB, edtSalary;
    Button btnAdd;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        txtView = findViewById(R.id.txtViewModel);
        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtDoB = findViewById(R.id.edtBirthDay);
        edtSalary = findViewById(R.id.edtSalary);
        btnAdd = findViewById(R.id.btnAdd);

        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);

        staffViewModel.getStaffList().observe(this, new Observer<List<Staff>>() {
            @Override
            public void onChanged(List<Staff> staffList) {
                updateResultText(staffList);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtID.getText().toString().trim();
                String name = edtName.getText().toString().trim();
                String birthDate = edtDoB.getText().toString().trim();
                String salary = edtSalary.getText().toString().trim();

                staffViewModel.addStaff(id, name, birthDate, salary);

                edtID.setText("");
                edtName.setText("");
                edtDoB.setText("");
                edtSalary.setText("");
            }
        });

    }

    private void updateResultText(List<Staff> staffList) {
        StringBuilder result = new StringBuilder();
        for (Staff staff : staffList) {
            result.append(staff.id).append("-")
                    .append(staff.name).append("-")
                    .append(staff.birthDate).append("-")
                    .append(staff.salary).append("\n");
        }
        if(result.length() != 0){
            txtView.setText(result.toString());
        }

    }
}