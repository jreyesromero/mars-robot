package com.ocs.marsrobot.controller;

import com.ocs.marsrobot.MarsRobotApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class MarsRobotApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String validJsonRequest = "{ \n" +
            "  \"terrain\": [ \n" +
            "    [\"Fe\", \"Fe\", \"Se\"], \n" +
            "    [\"W\", \"Si\", \"Obs\"], \n" +
            "    [\"W\", \"Obs\", \"Zn\"] \n" +
            "  ], \n" +
            "  \"battery\": 50, \n" +
            "  \"commands\": [ \n" +
            "    \"F\", \"S\", \"R\", \"F\", \"S\", \"R\", \"F\", \"L\", \"F\", \"S\" \n" +
            "    ], \n" +
            "  \"initialPosition\": { \n" +
            "    \"location\" : { \n" +
            "      \"x\" : 0, \n" +
            "      \"y\" : 0 \n" +
            "    }, \n" +
            "    \"facing\" : \"East\" \n" +
            "  } \n" +
            "} ";

    @Test
    public void testWithValidJson () throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/robot")
                .content(validJsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                      .andExpect(status().isOk());
    }

}