package com.radius.userdisplay;

public class User {

    private String image;
    private String name;
    private String email;
    private String gender;
    private String age;

    public User(String image, String name, String email, String gender, String age) {
        this.image = image;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
