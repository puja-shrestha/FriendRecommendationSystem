package com.example.puza.friendrecommendation.model;

public class User {

    private int image;
    private String name;
    private String description;

    private String FirstName;
    private String LastName;
    private String Address;

    public User() {
    }

    public User(String firstName, String lastName, String address) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Address = address;
    }


    public User(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
