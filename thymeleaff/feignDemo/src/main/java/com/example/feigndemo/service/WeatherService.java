package com.example.feigndemo.service;


import com.example.feigndemo.model.WeatherData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {


    private final String ApiKey = "93417bebdb312b48cd949a0ff097b944";
    private final FeignService feignService;

    public WeatherService(FeignService feignService) {
        this.feignService = feignService;
    }

    public WeatherData getWeather() {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            WeatherData responseData = objectMapper.readValue(feignService.weatherData(),WeatherData.class);

            return responseData;
        } catch (
                JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


  }





