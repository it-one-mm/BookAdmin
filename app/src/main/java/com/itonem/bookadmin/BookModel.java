package com.itonem.bookadmin;

public class BookModel {

    int Id;
    String Name;
    String Image;
    String Link;
    String Desc;
    String Category;
    String Author;

    public BookModel(int id, String name, String image, String link, String desc, String category, String author) {
        Id = id;
        Name = name;
        Image = image;
        Link = link;
        Desc = desc;
        Category = category;
        Author = author;
    }

    public BookModel() {
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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
