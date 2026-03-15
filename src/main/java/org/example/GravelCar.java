package org.example;

public class GravelCar extends RallyCar {
    public GravelCar(String make, String model, double horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return Math.round(horsepower * 1.5 * 100) / 100.0; // Rounded to 2 decimal places
    }
}