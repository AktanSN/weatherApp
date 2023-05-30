package com.example.feigndemo.service;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@FeignClient(name ="deneme", url= "https://api.openweathermap.org/data/2.5/forecast?q=london&appid=93417bebdb312b48cd949a0ff097b944")
public interface FeignService {


    @GetMapping
    String weatherData();





}
