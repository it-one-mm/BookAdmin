package com.itonem.bookadmin;

public class AuthorModel {

    int Id;
    String Name;
    String Image;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public AuthorModel(int id, String name, String image) {
        Id = id;
        Name = name;
        Image = image;
    }

    public AuthorModel(int id, String name) {
        Id = id;
        Name = name;
    }

    public AuthorModel() {
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
