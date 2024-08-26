package com.example.runnerz.run;

import java.time.LocalDateTime;

public record Run(Integer id,
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime completedOn,
                  Integer miles,
                  Location location) {

    public Run(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer miles, Location location) {
        this.id = id;
        this.title = title;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.miles = miles;
        this.location = location;
    }
}
