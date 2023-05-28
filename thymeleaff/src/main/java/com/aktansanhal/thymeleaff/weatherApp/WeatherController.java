package com.aktansanhal.thymeleaff.weatherApp;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(path = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getWeather(@RequestParam String cityName, @RequestParam String unit) {
        weatherService.setCityName(cityName);
        weatherService.setUnit(unit);
        JSONObject weatherData = weatherService.getWeather();
        if (weatherData != null) {
            return ResponseEntity.ok().body(weatherData.toString());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
