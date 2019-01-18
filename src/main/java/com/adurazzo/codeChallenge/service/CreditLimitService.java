package com.adurazzo.codeChallenge.service;


import com.adurazzo.codeChallenge.model.CreditLimit;
import com.adurazzo.codeChallenge.repository.CreditLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditLimitService {

    @Autowired
    CreditLimitRepository repo;


    public CreditLimit save(CreditLimit cl) {
        cl.check();
        cl.applyInterest();
        return repo.save(cl);

    }


}
