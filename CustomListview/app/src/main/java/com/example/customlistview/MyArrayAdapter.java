package com.example.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity Context;
    int idlayout; //Bất cứ thứ gì trong thư mục Res deu quan li bang id => int
    // Tạo constructor để MainActivity có thể gọi đến và truyền tham số vào
    ArrayList<Phone> mylist;

    public MyArrayAdapter(Activity context, int idlayout, ArrayList<Phone> mylist) {
        super(context, idlayout,mylist);
        Context = context;
        this.idlayout = idlayout;
        this.mylist = mylist;
    }
    //Gọi làm GetView để tiến hành sap xếp dữ liệu

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Tạo đế chứa Layout
        LayoutInflater myflater = Context.getLayoutInflater();
        // Đặt idlayout lên Inflater để tạo thành 1 đối tượng của View
        convertView = myflater.inflate(idlayout, null);
        // Lấy 1 phần tử trong mảng đổ vào View
        Phone  myphone = mylist.get(position);
        //Khai báo tham chiếu Id và hiển thị ảnh lên ImageView
        ImageView imgphone = convertView.findViewById(R.id.imgphone);
        imgphone.setImageResource(myphone.getImage());

        // Khai báo, tham chiếu Id và hiển thị teen điện thoại lên Text View
        TextView txtPhone = convertView.findViewById(R.id.txtPhone);
        txtPhone.setText(myphone.getName());
        return convertView;

    }
}
