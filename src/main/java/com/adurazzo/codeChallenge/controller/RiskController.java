package com.adurazzo.codeChallenge.controller;


import com.adurazzo.codeChallenge.enums.RiskEnumStrategy;
import com.adurazzo.codeChallenge.model.Risk;
import com.adurazzo.codeChallenge.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/risk")
public class RiskController {


    @Autowired
    RiskRepository repository;



    @GetMapping
    public List<RiskEnumStrategy> getAll() {
        RiskEnumStrategy[] values = RiskEnumStrategy.values();
        return Arrays.asList(values);
    }

    @GetMapping("/{id}")
    public Risk one(@PathVariable(value = "id") String id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException(id)
        );
    }

    @PostMapping
    Risk newRisk(@RequestBody Risk newRisk) {
        return repository.save(newRisk);
    }

    @PutMapping("/{id}")
    Risk replaceRisk(@RequestBody Risk newRisk, @PathVariable String id) {

        return repository.findById(id)
                .map(risk -> {

                    risk.setValue(newRisk.getValue());
                    return repository.save(risk);
                })
                .orElseGet(() -> {
                    newRisk.setId(id);
                    return repository.save(newRisk);
                });
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }
}
