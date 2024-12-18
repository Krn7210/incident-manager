package com.example.inicident_management.dto;


import lombok.*;



public class UserDto {
    private String username;


    private String email;


    private String phone;


    private String address;


    private String pinCode;


    private String city;


    private String country;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserDto() {
    }

    public UserDto(String address, String username, String email, String phone, String pinCode, String city, String country) {
        this.address = address;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.pinCode = pinCode;
        this.city = city;
        this.country = country;
    }
}
