package com.example.prac03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.widget.ImageView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<Country> countryList;
    private OnCountryClickListener listener;

    public interface OnCountryClickListener {
        void onCountryClick(Country country);
    }

    public CountryAdapter(List<Country> countryList, OnCountryClickListener listener) {
        this.countryList = countryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country currentCountry = countryList.get(position);
        holder.textViewCountryName.setText(currentCountry.getName());
        holder.textViewPopulation.setText("Dân số: " + currentCountry.getPopulation());
        holder.imageViewFlag.setImageResource(currentCountry.getFlagResource());

        holder.itemView.setOnClickListener(v -> listener.onCountryClick(currentCountry));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCountryName;
        TextView textViewPopulation;
        ImageView imageViewFlag;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCountryName = itemView.findViewById(R.id.textView_countryName);
            textViewPopulation = itemView.findViewById(R.id.textView_population);
            imageViewFlag = itemView.findViewById(R.id.imageView_flag);
        }
    }
}
