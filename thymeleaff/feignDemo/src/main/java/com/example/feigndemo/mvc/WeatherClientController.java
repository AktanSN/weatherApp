package com.example.feigndemo.mvc;


import com.example.feigndemo.model.WeatherData;
import com.example.feigndemo.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherClientController {

    private WeatherService weatherService;

    public WeatherClientController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/weather")
    public String searchWeather() {
        return "weather";
    }


}
