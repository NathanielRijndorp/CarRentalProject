package com.example.carrentalproject;

public class Customer {

    private int id;
    private String name;
    private String car;
    private String car_type;
    private int days;
    private String color;
    private String date_start;
    private String date_end;
    private int price;

    public Customer(int id, String name, String car, String car_type, String color, String date_start, String date_end, int days, int price) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.car_type = car_type;
        this.color = color;
        this.date_start = date_start;
        this.date_end = date_end;
        this.days = days;
        this.price = price;
    }
    public Customer(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
