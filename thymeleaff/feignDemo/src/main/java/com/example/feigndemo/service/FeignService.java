package com.example.feigndemo.service;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@FeignClient(name ="deneme", url= "https://api.openweathermap.org/data/2.5/weather")
public interface FeignService {


    @GetMapping
    String weatherData(@RequestParam String q, @RequestParam String units, @RequestParam String appid);





}
