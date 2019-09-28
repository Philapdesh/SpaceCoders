package com.example.easy_ride.Model;

public class User {
    private String Name,Surname,PhysicalAddress,code,contact,Email,Password,Ammount,IDnumber;

    public User() {
    }

    public User(String name, String surname, String physicalAddress, String code, String contact, String email, String password, String ammount, String IDnumber) {
        Name = name;
        Surname = surname;
        PhysicalAddress = physicalAddress;
        this.code = code;
        this.contact = contact;
        Email = email;
        Password = password;
        Ammount = ammount;
        this.IDnumber = IDnumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPhysicalAddress() {
        return PhysicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        PhysicalAddress = physicalAddress;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAmmount() {
        return Ammount;
    }

    public void setAmmount(String ammount) {
        Ammount = ammount;
    }

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }
}
