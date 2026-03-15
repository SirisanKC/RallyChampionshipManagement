package org.example;

public class AsphaltCar extends RallyCar {
    public AsphaltCar(String make, String model, double horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return Math.round(horsepower * 1.8 * 100) / 100.0; // Rounded to 2 decimal places
    }
}