package com.example.prac03;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class CountryDetailActivity extends AppCompatActivity {
    private ImageView imageViewFlag;
    private TextView textViewCountryNameDetail;
    private TextView textViewPopulationDetail;
    private TextView textViewDetails;
    private TextView textViewArea;
    private TextView textViewDensity;
    private TextView textViewWorldShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        imageViewFlag = findViewById(R.id.imageView_flag);
        textViewCountryNameDetail = findViewById(R.id.textView_countryNameDetail);
        textViewPopulationDetail = findViewById(R.id.textView_populationDetail);
        textViewDetails = findViewById(R.id.textView_details);
        textViewArea = findViewById(R.id.textView_area);
        textViewDensity = findViewById(R.id.textView_density);
        textViewWorldShare = findViewById(R.id.textView_worldShare);


        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String countryName = intent.getStringExtra("countryName");
        long population = intent.getLongExtra("population", 0);
        String details = intent.getStringExtra("details");
        int flagResource = intent.getIntExtra("flagResource", 0);  // Nhận tài nguyên hình ảnh
        double area = intent.getDoubleExtra("area", 0);
        double density = intent.getDoubleExtra("density", 0);
        double worldShare = intent.getDoubleExtra("worldShare", 0);

        // Thiết lập dữ liệu vào các View
        textViewCountryNameDetail.setText(countryName);
        textViewPopulationDetail.setText("Dân số: " + population);
        textViewDetails.setText(details);

        textViewArea.setText("Diện tích: " + area + " km²");
        textViewDensity.setText("Mật độ: " + density + " người/km²");
        textViewWorldShare.setText("Tỷ lệ thế giới: " + worldShare + "%");

        imageViewFlag.setImageResource(flagResource);  // Hiển thị hình ảnh quốc kỳ
    }
}
