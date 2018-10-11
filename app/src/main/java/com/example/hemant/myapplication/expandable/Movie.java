package com.example.hemant.myapplication.expandable;

import com.google.gson.annotations.SerializedName;

public class Movie {

    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("desc")
    private String desc;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("category")
    private String categoty;

    private boolean isChecked;

    public Movie(String name, String desc, String imageUrl, String categoty) {
        this.name = name;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.categoty = categoty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategoty() {
        return categoty;
    }

    public void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                "isChecked='" + isChecked + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", categoty='" + categoty + '\'' +
                '}';
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
