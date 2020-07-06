package com.itonem.bookadmin;

public class CategoryModel {

    int Id;
    String Name;
    String Image;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public CategoryModel(int id, String name, String image) {
        Id = id;
        Name = name;
        Image = image;
    }

    public CategoryModel(int id, String name) {
        Id = id;
        Name = name;
    }

    public CategoryModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
