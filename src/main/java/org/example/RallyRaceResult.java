package org.example;

import java.util.ArrayList;
import java.util.List;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private List<String> results;

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
        results = new ArrayList<>();
    }

    @Override
    public void recordResult(Driver driver, int position) {
        int points = calculatePoints(position);
        results.add("Position " + position + ": " + driver.getName() + " - " + points + " points");
        driver.addPoints(points); // Add points to driver's total
    }

    @Override
    public List<String> getResults() {
        // Add an empty line after the last position
        if (!results.isEmpty()) {
            results.add(""); // Add an empty line
        }
        return results;
    }

    public String getRaceName() {
        return raceName;
    }

    private int calculatePoints(int position) {
        switch (position) {
            case 1: return 25;
            case 2: return 18;
            case 3: return 15;
            case 4: return 12;
            default: return 0;
        }
    }
}