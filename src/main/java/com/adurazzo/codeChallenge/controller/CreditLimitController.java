package com.adurazzo.codeChallenge.controller;


import com.adurazzo.codeChallenge.exceptions.CreditLimitNotFoundException;
import com.adurazzo.codeChallenge.model.CreditLimit;
import com.adurazzo.codeChallenge.repository.CreditLimitRepository;
import com.adurazzo.codeChallenge.service.CreditLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/creditLimit")
@CrossOrigin(origins = "*")
public class CreditLimitController {

    @Autowired
    private CreditLimitRepository repo;

    @Autowired
    private CreditLimitService service;

    @GetMapping("/")
    List<CreditLimit> all(){
        return repo.findAll();

    }

    @PostMapping("/")
    CreditLimit newEmployee(@RequestBody CreditLimitPresenter newCL) {
        return service.save(newCL);
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

/*    @PutMapping("/{id}")
    CreditLimit replaceEmployee(@RequestBody CreditLimit newCreditLimit, @PathVariable String id) {

        return repo.findById(id)
                .map(creditLimit -> {
                    creditLimit.setClientName(newCreditLimit.getClientName());
                    creditLimit.setCreditLimit(creditLimit.getCreditLimit());
                    creditLimit.setType(newCreditLimit.getType());
                    return service.save(creditLimit);
                })
                .orElseGet(() -> {
                    newCreditLimit.setId(id);
                    return service.save(newCreditLimit);
                });
    }*/

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable String id) {
        repo.deleteById(id);
    }


}

