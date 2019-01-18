package com.adurazzo.codeChallenge.repository;

import com.adurazzo.codeChallenge.model.Risk;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RiskRepository extends MongoRepository<Risk, String> {

}
