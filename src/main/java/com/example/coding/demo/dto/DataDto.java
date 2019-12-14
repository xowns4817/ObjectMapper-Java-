package com.example.coding.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {

    //@JsonProperty("attend_name") // 강제적으로 해당 이름으로 매핑시킴
    private String name;

    //@JsonProperty("attend_age")
    private int age;
}
