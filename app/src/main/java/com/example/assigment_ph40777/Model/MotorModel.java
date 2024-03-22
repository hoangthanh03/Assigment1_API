package com.example.assigment_ph40777.Model;

public class MotorModel {
    private String _id;
    private String motoName;
    private int date;
    private String theFirm;
    private double price;

    public MotorModel() {
    }

    public MotorModel(String _id, String motoName, int date, String theFirm, double price) {
        this._id = _id;
        this.motoName = motoName;
        this.date = date;
        this.theFirm = theFirm;
        this.price = price;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMotoName() {
        return motoName;
    }

    public void setMotoName(String motoName) {
        this.motoName = motoName;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getTheFirm() {
        return theFirm;
    }

    public void setTheFirm(String theFirm) {
        this.theFirm = theFirm;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
