package com.example.easy_ride.Model;

public class Rides {
    private String UserID,DriverID,Name,Surname,Paymentprice,Status,DateTime;

    public Rides() {
    }

    public Rides(String userID, String driverID, String name, String surname, String paymentprice, String status, String dateTime) {
        UserID = userID;
        DriverID = driverID;
        Name = name;
        Surname = surname;
        Paymentprice = paymentprice;
        Status = status;
        DateTime = dateTime;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getDriverID() {
        return DriverID;
    }

    public void setDriverID(String driverID) {
        DriverID = driverID;
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

    public String getPaymentprice() {
        return Paymentprice;
    }

    public void setPaymentprice(String paymentprice) {
        Paymentprice = paymentprice;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }
}
