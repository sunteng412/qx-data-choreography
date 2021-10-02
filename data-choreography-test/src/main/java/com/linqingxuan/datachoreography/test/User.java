package com.linqingxuan.datachoreography.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String passwd;

}