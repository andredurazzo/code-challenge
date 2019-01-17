package com.adurazzo.codeChallenge.controller;


import com.adurazzo.codeChallenge.exception.CreditLimitNotFoundException;
import com.adurazzo.codeChallenge.model.CreditLimit;
import com.adurazzo.codeChallenge.repository.CreditLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/creditLimit")
public class CreditLimitController {

    @Autowired
    private CreditLimitRepository repo;

    @GetMapping("/")
    List<CreditLimit> all(){
        return repo.findAll();

    }

    @GetMapping("/{id}")
    CreditLimit one(@PathVariable(value = "id") String id) {

        return repo.findById(id)
                .orElseThrow(() -> new CreditLimitNotFoundException(id));
    }

    @GetMapping("/client/{name}")
    CreditLimit byName(@PathVariable(value = "name") String name) {

        return repo.findByClientNameContaining(name)
                .orElseThrow(() -> new CreditLimitNotFoundException(name));
    }

}
