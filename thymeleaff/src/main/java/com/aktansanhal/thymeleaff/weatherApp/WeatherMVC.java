package com.aktansanhal.thymeleaff.weatherApp;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class WeatherMVC {

    private final WeatherService weatherService;

    @Autowired
    public WeatherMVC(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    //http://localhost:8080/weather?cityName=ankara&unit=metric
    @GetMapping(path = "/weather")
    public String getWeather(@RequestParam String cityName, @RequestParam String unit, Model model) {
        weatherService.setCityName(cityName);
        weatherService.setUnit(unit);
        JSONObject weatherData = weatherService.getWeather();
        if (weatherData != null) {
            Weather weather = parseWeatherData(weatherData);
            model.addAttribute("weather", weather);
        }
        return "weather";
    }

    private Weather parseWeatherData(JSONObject weatherData) {
        weatherData = weatherService.getWeather();
        System.out.println(weatherData);
        try {
            String description = weatherData.getJSONArray("weather").getJSONObject(0).getString("description");
            String icon = weatherData.getJSONArray("weather").getJSONObject(0).getString("icon");
            double temp = weatherData.getJSONObject("main").getDouble("temp");
            double feelsLike = weatherData.getJSONObject("main").getDouble("feels_like");
            double tempMin = weatherData.getJSONObject("main").getDouble("temp_min");
            double tempMax = weatherData.getJSONObject("main").getDouble("temp_max");
            int pressure = weatherData.getJSONObject("main").getInt("pressure");
            int humidity = weatherData.getJSONObject("main").getInt("humidity");
            double windSpeed = weatherData.getJSONObject("wind").getDouble("speed");
            int windDeg = weatherData.getJSONObject("wind").getInt("deg");
            String country = weatherData.getJSONObject("sys").getString("country");
            String sunrise = weatherData.getJSONObject("sys").getString("sunrise");
            String sunset = weatherData.getJSONObject("sys").getString("sunset");
            String name = weatherData.getString("name");

            return new Weather(description, icon, temp, feelsLike, tempMin, tempMax, pressure, humidity, windSpeed, windDeg, country, sunrise, sunset, name);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

}