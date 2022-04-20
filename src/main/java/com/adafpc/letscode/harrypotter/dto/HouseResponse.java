package com.adafpc.letscode.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseResponse {

    private String name;
    private String animal;
    private String founder;
    private List<NamedValues> values;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NamedValues{
        private String name;
    }
}
