package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RaceResult> raceResults;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        raceResults = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void recordRaceResult(RaceResult result) {
        raceResults.add(result);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public void calculateStandings() {
        drivers.sort(Comparator.comparingInt(Driver::getTotalPoints).reversed());
    }

    public Driver getChampionshipLeader() {
        return drivers.isEmpty() ? null : drivers.get(0);
    }

    public int getTotalDrivers() {
        return drivers.size();
    }

    public int getTotalRaces() {
        return raceResults.size();
    }

    public double calculateAveragePoints() {
        double totalPoints = drivers.stream().mapToInt(Driver::getTotalPoints).sum();
        return totalPoints / drivers.size();
    }

    public String findMostSuccessfulCountry() {
        Map<String, Integer> countryPoints = drivers.stream()
                .collect(Collectors.groupingBy(Driver::getCountry, Collectors.summingInt(Driver::getTotalPoints)));

        return countryPoints.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Country");
    }

    public int getTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getTotalPoints).sum();
    }
}