package com.example.btth3;

import com.example.btth3.R;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialog;

import java.util.List;

public class AddStudentDialog {

    private Context context;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    private MainActivity mainActivity;

    public AddStudentDialog(Context context, StudentAdapter studentAdapter, List<Student> studentList, MainActivity mainActivity) {
        this.context = context;
        this.studentAdapter = studentAdapter;
        this.studentList = studentList;
        this.mainActivity = mainActivity;
    }


    public void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.activity_add_student, null);
        builder.setView(dialogView);

        EditText etHoTen = dialogView.findViewById(R.id.txtHoten);
        EditText etNgaySinh = dialogView.findViewById(R.id.txtBirthDate);
        EditText etEmail = dialogView.findViewById(R.id.txtEmail);
        EditText etDiaChi = dialogView.findViewById(R.id.txtEmail);
        EditText etChuyenNganh = dialogView.findViewById(R.id.txtChuyenNganh);
        EditText etGPA = dialogView.findViewById(R.id.txtGPA);
        RadioGroup rgGioiTinh = dialogView.findViewById(R.id.rgGioiTinh);
        Button btnHoanTat = dialogView.findViewById(R.id.btnHoanTat);

        AlertDialog dialog = builder.create();

        btnHoanTat.setOnClickListener(v -> {
            String hoTen = etHoTen.getText().toString();
            String ngaySinh = etNgaySinh.getText().toString();
            String email = etEmail.getText().toString();
            String diaChi = etDiaChi.getText().toString();
            String chuyenNganh = etChuyenNganh.getText().toString();
            String gpa = etGPA.getText().toString();
            String gioiTinh = "";

            int selectedId = rgGioiTinh.getCheckedRadioButtonId();
            if (selectedId == R.id.rbNam) {
                gioiTinh = "Nam";
            } else if (selectedId == R.id.rbNu) {
                gioiTinh = "Nữ";
            } else {
                gioiTinh = "Khác";
            }


            int newId = studentList.size() + 1;


            Student newStudent = new Student(newId, hoTen, ngaySinh, email, diaChi, chuyenNganh, Double.parseDouble(gpa), gioiTinh);


            studentList.add(newStudent);
            studentAdapter.notifyDataSetChanged();

            mainActivity.saveToInternalStorage();
            dialog.dismiss();
            Toast.makeText(context, "Sinh viên đã được thêm!", Toast.LENGTH_SHORT).show();
        });

        dialog.show();
    }
}
