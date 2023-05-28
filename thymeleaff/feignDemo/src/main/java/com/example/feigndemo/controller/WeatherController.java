package com.example.feigndemo.controller;


import com.example.feigndemo.service.FeignService;
import com.example.feigndemo.model.WeatherData;
import com.example.feigndemo.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/data")
    public WeatherData getFromController(@RequestParam String cityName, @RequestParam String metric){


        return weatherService.getWeather(cityName,metric);
    }

    @GetMapping("/outfit")
    public String getOutfitRecommendation(@RequestParam String cityName, @RequestParam String metric){
        return weatherService.getOutfitRecommendation(weatherService.getWeather(cityName,metric));
    }



}
