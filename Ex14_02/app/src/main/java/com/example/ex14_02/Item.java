package com.example.ex14_02;

public class Item {
    private String maSo, TieuDe;
    private Integer Thich;

    public Item(String maSo, String tieuDe, Integer thich) {
        this.maSo = maSo;
        TieuDe = tieuDe;
        Thich = thich;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public Integer getThich() {
        return Thich;
    }

    public void setThich(Integer thich) {
        Thich = thich;
    }
}
