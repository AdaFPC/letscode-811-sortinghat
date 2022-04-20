package com.adafpc.letscode.harrypotter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class StudentRequest {

    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String grade;

}
