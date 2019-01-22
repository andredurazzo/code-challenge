package com.adurazzo.codeChallenge.controller;


import com.adurazzo.codeChallenge.repository.CreditLimitRepository;
import com.adurazzo.codeChallenge.service.CreditLimitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
@TestInstance(Lifecycle.PER_CLASS)
@ActiveProfiles({"test"})
public class CreditLimitControllerTest {

    @Autowired
    private CreditLimitService service;
    @Autowired
    private CreditLimitRepository repository;


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void getAccount() throws Exception {
        mockMvc.perform (get("/creditLimit/123")).andExpect(status().isOk());
    }



}
