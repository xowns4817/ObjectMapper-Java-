package com.example.coding.demo;

import com.example.coding.demo.dto.DataDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Autowired
    DataDto dataDto;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/test")
    public Object test( ) {

        String jsonData =  "{\"name\": \"김태준\", \"age\": \"21\"}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            dataDto = mapper.readValue(jsonData, DataDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return dataDto;
    }
}
