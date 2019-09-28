package com.example.easy_ride.Model;

public class Driver {
    private String idnumber,FullName,Surname,Contact,Address,Code,Email,password,TotatAmount,NumberPlate,OwnerCode;

    public Driver() {
    }

    public Driver(String idnumber, String fullName, String surname, String contact, String address, String code, String email, String password, String totatAmount, String numberPlate, String ownerCode) {
        this.idnumber = idnumber;
        FullName = fullName;
        Surname = surname;
        Contact = contact;
        Address = address;
        Code = code;
        Email = email;
        this.password = password;
        TotatAmount = totatAmount;
        NumberPlate = numberPlate;
        OwnerCode = ownerCode;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTotatAmount() {
        return TotatAmount;
    }

    public void setTotatAmount(String totatAmount) {
        TotatAmount = totatAmount;
    }

    public String getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        NumberPlate = numberPlate;
    }

    public String getOwnerCode() {
        return OwnerCode;
    }

    public void setOwnerCode(String ownerCode) {
        OwnerCode = ownerCode;
    }
}
