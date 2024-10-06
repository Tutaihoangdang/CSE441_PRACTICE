package com.example.prac03;

public class Country {
    private String name;
    private long population;
    private String details;
    private int flagResource;
    private double area;  // Thêm diện tích
    private double density;  // Thêm mật độ dân số
    private double worldShare;  // Thêm tỷ lệ thế giới

    public Country(String name, long population, String details, int flagResource, double area, double density, double worldShare) {
        this.name = name;
        this.population = population;
        this.details = details;
        this.flagResource = flagResource;
        this.area = area;
        this.density = density;
        this.worldShare = worldShare;
    }

    // Getters
    public String getName() { return name; }
    public long getPopulation() { return population; }
    public String getDetails() { return details; }
    public int getFlagResource() { return flagResource; }
    public double getArea() { return area; }
    public double getDensity() { return density; }
    public double getWorldShare() { return worldShare; }
}
