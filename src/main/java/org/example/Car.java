package org.example;

import java.time.Year;

public class Car {
    private String make;
    private String model;
    private double price;
    private int year;

    private static final double MINIMUM_PRICE = 0.0;
    private static final int MINIMUM_YEAR = 1886;
    private static final int CURRENT_YEAR = Year.now().getValue();

    public Car() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.price = 0.0;
        this.year = 2000;
    }

    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public double calculateDepreciation() {
        return this.price * Math.pow(0.85, CURRENT_YEAR - this.getYear());
    }

    public void print() {
        System.out.printf("This is a %s, more specifically a %s, it was made in %d, and it costs $%.2f.", this.getMake(), this.getModel(), this.getYear(), this.getPrice());
    }

    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = Math.max(year, MINIMUM_YEAR);
    }
    public void setPrice(double price) {
        this.price = Math.max(price, MINIMUM_PRICE);
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public double getPrice() {
        return this.price;
    }

    public int getYear() {
        return this.year;
    }




}
