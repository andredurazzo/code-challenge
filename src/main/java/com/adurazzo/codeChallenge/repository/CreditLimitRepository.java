package com.adurazzo.codeChallenge.repository;

import com.adurazzo.codeChallenge.model.CreditLimit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditLimitRepository extends MongoRepository<CreditLimit, String> {

    Optional<CreditLimit> findByClientNameContaining(String name);

}
