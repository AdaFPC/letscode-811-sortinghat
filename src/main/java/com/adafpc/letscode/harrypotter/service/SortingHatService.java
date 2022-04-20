package com.adafpc.letscode.harrypotter.service;

import com.adafpc.letscode.harrypotter.dto.HouseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
@Slf4j
public class SortingHatService {

    private RestTemplate restTemplate = new RestTemplate();

    public String getHouseId(){

       Map<String, Object> house = restTemplate.getForObject("https://api-harrypotter.herokuapp.com/sortinghat", Map.class);
        log.info("A casa selecionada tem o ID : {}", house.get("sorting-hat-choice"));
        return String.valueOf( house.get("sorting-hat-choice"));
    }

    public HouseResponse getHouseDetails(String id){

        HouseResponse house = restTemplate.getForObject("https://api-harrypotter.herokuapp.com/house/" + id, HouseResponse.class);
        log.info("Casa selecionada : {}", house);

        return house;
    }
}
