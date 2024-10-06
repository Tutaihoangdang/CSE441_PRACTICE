package com.example.recycleview;

public class Country {
    private int flag;
    private String CountryName;
    private String CountryCapital;


    public Country(int flag, String countryName, String countryCapital) {
        this.flag = flag;
        CountryName = countryName;
        CountryCapital = countryCapital;
    }

    public int getFlag() {
        return flag;
    }

    public String getCountryCapital() {
        return CountryCapital;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public void setCountryCapital(String countryCapital) {
        CountryCapital = countryCapital;
    }
}
