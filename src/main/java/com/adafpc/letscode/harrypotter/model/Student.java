package com.adafpc.letscode.harrypotter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private Integer id;
    private String name;
    private String grade;
    private String house;


}
