package com.adurazzo.codeChallenge.service;


import com.adurazzo.codeChallenge.controller.CreditLimitPresenter;
import com.adurazzo.codeChallenge.model.CreditLimit;
import com.adurazzo.codeChallenge.repository.CreditLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditLimitService {

    @Autowired
    CreditLimitRepository repo;


    public CreditLimit save(CreditLimitPresenter clp) {
        CreditLimit cl = new CreditLimit();
        cl.setType(clp.getType());
        cl.setCreditLimit(clp.getCreditLimit());
        cl.setClientName(clp.getClientName());
        cl.check();
        cl.applyInterest();
        return repo.save(cl);

    }


}
