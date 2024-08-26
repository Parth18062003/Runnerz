package com.example.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("/")
    String hello() {
        return "Hello, Runnerz!";
    }
    
    @GetMapping("/api/runs")
    List<Run> findAll() {
        return runRepository.getRuns();
    }

    @GetMapping("/api/runs/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()) {
            throw new RunNotFoundException("Run not found");
        } else {
            return run.get();
        }
    }

    @PostMapping("/api/runs")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody Run run) {
        runRepository.create(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/api/runs/{id}")
    void update(@PathVariable Integer id, @RequestBody Run run) {
        Optional<Run> existingRun = runRepository.findById(id);
        if(existingRun.isEmpty()) {
            throw new RunNotFoundException("Run not found");
        } else {
            runRepository.update(id, run);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/runs/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }

}
