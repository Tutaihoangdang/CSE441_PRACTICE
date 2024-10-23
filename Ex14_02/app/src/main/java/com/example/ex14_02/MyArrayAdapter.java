package com.example.ex14_02;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ex14_02.Item;
import com.example.ex14_02.R;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Item> {
    Activity context = null;
    ArrayList<Item> myArray = null;
    int LayoutId;

    public MyArrayAdapter( Activity context, ArrayList<Item> arr, int LayoutId) {
        super(context, LayoutId, arr);
        this.context = context;
        this.myArray = arr;
        this.LayoutId = LayoutId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(LayoutId, parent, false);
        }

        Item myItem = myArray.get(position);

        ImageView btnLike = convertView.findViewById(R.id.imgLike);
        int thich = myItem.getThich();
        if (thich == 1) {
            btnLike.setImageResource(R.drawable.ic_launcher_foreground);
        } else {
            btnLike.setImageResource(R.drawable.ic_launcher_foreground);
        }

        TextView tieude = convertView.findViewById(R.id.txtTieuDe);
        tieude.setText(myItem.getTieuDe());

        TextView maso = convertView.findViewById(R.id.txtMaSo);
        maso.setText(myItem.getMaSo());

        return convertView;
    }


}