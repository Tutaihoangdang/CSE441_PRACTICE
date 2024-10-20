package com.example.btth3;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String hoTen;
    String ngaySinh;
    String email;
    String diaChi;
    String chuyenNganh;
    double gpa;
    String gioiTinh;

    public Student(int id, String hoTen, String ngaySinh, String email, String diaChi, String chuyenNganh, double gpa, String gioiTinh) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diaChi = diaChi;
        this.chuyenNganh = chuyenNganh;
        this.gpa = gpa;
        this.gioiTinh = gioiTinh;
    }
}

