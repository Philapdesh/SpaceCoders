package com.example.easy_ride.Model;

public class Token {
    private String Status,Amount;

    public Token() {
    }

    public Token(String status, String amount) {
        Status = status;
        Amount = amount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
