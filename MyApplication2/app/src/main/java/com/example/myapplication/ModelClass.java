package com.example.myapplication;

public class ModelClass {
    private final String maintitle;
    private  final String subtitle;

    public String getMaintitle() {
        return maintitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Integer getImg() {
        return img;
    }

    private  final Integer img;

    public ModelClass(String maintitle, String subtitle, Integer img) {
        this.maintitle = maintitle;
        this.subtitle = subtitle;
        this.img = img;
    }

}
