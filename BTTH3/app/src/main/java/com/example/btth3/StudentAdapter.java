package com.example.btth3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> students;
    private Context context;
    private OnStudentClickListener onStudentClickListener;

    public interface OnStudentClickListener {
        void onStudentClick(Student student);
    }

    public StudentAdapter(List<Student> students, Context context, OnStudentClickListener listener) {
        this.students = students;
        this.context = context;
        this.onStudentClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.textViewID.setText("ID: " + student.id);
        holder.nameTextView.setText(student.hoTen);
        holder.gpaTextView.setText("GPA: " + student.gpa);

        // Thiết lập hình ảnh dựa trên giới tính
        if ("Nam".equals(student.gioiTinh)) {
            holder.imageViewGender.setImageResource(R.drawable.male);
        } else if("Nữ".equals(student.gioiTinh)) {
            holder.imageViewGender.setImageResource(R.drawable.female);
        }
        else  {
            holder.imageViewGender.setImageResource(R.drawable.other);
        }

        holder.itemView.setOnClickListener(v -> onStudentClickListener.onStudentClick(student));
    }



    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewID;
        TextView nameTextView;
        TextView gpaTextView;
        ImageView imageViewGender;  // Khai báo ImageView

        public ViewHolder(View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.textViewID);
            nameTextView = itemView.findViewById(R.id.textViewName);
            gpaTextView = itemView.findViewById(R.id.textViewGPA);
            imageViewGender = itemView.findViewById(R.id.imageViewGender); // Ánh xạ ImageView
        }
    }

}

