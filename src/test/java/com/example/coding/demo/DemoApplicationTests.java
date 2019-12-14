package com.example.coding.demo;

import com.example.coding.demo.dto.DataDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DataDto dataDto;

    @Autowired
    ObjectMapper mapper;

    // JSON -> JAVA Object ( readValue ) -> Json 객체 1개
    @Test
    void contextLoads() {

        String jsonData =  "{\"name\": \"김태준\", \"age\": \"28\"}";
        try {
             dataDto = mapper.readValue(jsonData, DataDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(dataDto);
    }

    // JSON -> JAVA Object ( readValue ) -> JSON Array
    @Test
    void contextLoads2( ) {
        String JsonArray= "[{\"name\" : \"김태준\", \"age\" : \"28\"}," +
                " {\"name\" : \"KTJ\", \"age\" : \"20\"}]";
        ArrayList<DataDto> dataList = null;

        try {
            dataList = mapper.readValue(JsonArray, new TypeReference<ArrayList<DataDto>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(dataList.toString());
    }

    // JSON -> MAP ( readValue )
    @Test
    void contextLoad3( ) {

        String jsonData =  "{\"name\": \"김태준\", \"age\": \"28\"}";
        Map<String, String> map = null;
        try {
            map = mapper.readValue(jsonData, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(map);
    }

    // JAVA Object -> JSON ( writeValueAsString )
    @Test
    void contextLoads4( ) {

        dataDto.setName("김태준");
        dataDto.setAge(28);
        String JsonString = null;

        try {
             JsonString = mapper.writeValueAsString(dataDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(JsonString);
    }

}
