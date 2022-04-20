package com.adafpc.letscode.harrypotter.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class StudentResponse extends StudentRequest{
    private Integer id;
    private HouseResponse house;
}
