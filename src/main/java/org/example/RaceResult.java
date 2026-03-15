package org.example;

import java.util.List;

public interface RaceResult {
    void recordResult(Driver driver, int position);
    List<String> getResults();
}