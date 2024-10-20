package com.example.prac03;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CountryAdapter.OnCountryClickListener {
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        countryList = new ArrayList<>();
        countryList.add(new Country("Việt Nam", 100000000, "Thông tin chi tiết về Việt Nam:", R.drawable.flag_vietnam, 331212, 295, 1.25));
        countryList.add(new Country("Indonesia", 270000000, "Thông tin chi tiết về Indonesia:", R.drawable.flag_indonesia,1000,1000,1000));
        countryList.add(new Country("Pakistan", 225625000, "Thông tin chi tiết về Pakistan:", R.drawable.flag_pakistan,1000,1000,1000));
        countryList.add(new Country("Brazil", 213000000, "Thông tin chi tiết về Brazil:", R.drawable.flag_brazil,1000,1000,1000));
        countryList.add(new Country("Trung Quốc", 1420300000, "Thông tin chi tiết về Trung Quốc:", R.drawable.flag_china, 9596961, 146, 18.47));
        countryList.add(new Country("Nigeria", 211000000, "Thông tin chi tiết về Nigeria:", R.drawable.flag_nigeria,1000,1000,1000));
        countryList.add(new Country("Ấn Độ", 1390000000, "Thông tin chi tiết về Ấn Độ:", R.drawable.flag_india, 1000,1000,1000));
        countryList.add(new Country("Bangladesh", 166140000, "Thông tin chi tiết về Bangladesh:", R.drawable.flag_bangladesh,1000,1000,1000));
        countryList.add(new Country("Hoa Kỳ", 331367900, "Thông tin chi tiết về Hoa Kỳ:", R.drawable.flag_usa, 1000,1000,1000));
        countryList.add(new Country("Nga", 146458200, "Thông tin chi tiết về Nga:", R.drawable.flag_nga,1000,1000,1000));

        countryAdapter = new CountryAdapter(countryList, this);
        recyclerView.setAdapter(countryAdapter);
    }

    @Override
    public void onCountryClick(Country country) {
        Intent intent = new Intent(this, CountryDetailActivity.class);
        intent.putExtra("countryName", country.getName());
        intent.putExtra("population", country.getPopulation());
        intent.putExtra("details", country.getDetails());
        intent.putExtra("flagResource", country.getFlagResource());
        intent.putExtra("area", country.getArea());
        intent.putExtra("density", country.getDensity());
        intent.putExtra("worldShare", country.getWorldShare());
        startActivity(intent);
    }
}
