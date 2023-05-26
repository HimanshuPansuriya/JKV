package com.example.jkv.modal;

public class BathroomAccessoriesModal {

    int image;

    String access_name;

    public BathroomAccessoriesModal(int image, String access_name) {
        this.image = image;
        this.access_name = access_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAccess_name() {
        return access_name;
    }

    public void setAccess_name(String access_name) {
        this.access_name = access_name;
    }
}
