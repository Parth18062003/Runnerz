package com.example.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> getRuns() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    public void create(Run run) {
        runs.add(run);
    }

    public void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    void update(Integer id, Run run) {
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        } else {
            throw new IllegalArgumentException("Run not found");
        }
    }
    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Long Run", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.MINUTES),5,Location.OUTDOOR));
        runs.add(new Run(2, "Quick Run", LocalDateTime.now(),LocalDateTime.now().plus(2,ChronoUnit.MINUTES),7, Location.INDOOR));
    }
}
