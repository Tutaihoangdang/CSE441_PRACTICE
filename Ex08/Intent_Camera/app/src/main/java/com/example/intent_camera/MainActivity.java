package com.example.intent_camera;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

public class MainActivity extends AppCompatActivity {
    ImageView myimg;
    ImageButton btncapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myimg = findViewById(R.id.myimg);
        btncapture = findViewById(R.id.btncapture);

        btncapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra quyền camera trước khi mở ứng dụng camera
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Yêu cầu quyền camera nếu chưa được cấp
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    // Quyền camera đã được cấp, mở ứng dụng camera
                    Intent myintent = new Intent(ACTION_IMAGE_CAPTURE);
                    startActivityForResult(myintent, 99);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == Activity.RESULT_OK) {
            // Nhận ảnh từ camera và hiển thị trong ImageView
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            myimg.setImageBitmap(photo);
        }
    }

    // Xử lý yêu cầu quyền của người dùng
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Quyền camera được cấp, mở ứng dụng camera
                Intent myintent = new Intent(ACTION_IMAGE_CAPTURE);
                startActivityForResult(myintent, 99);
            } else {
                // Quyền camera bị từ chối, xử lý trường hợp quyền bị từ chối
            }
        }
    }
}
