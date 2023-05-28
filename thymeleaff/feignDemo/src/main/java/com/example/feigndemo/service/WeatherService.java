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

    public WeatherData getWeather(String cityName, String metric) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            WeatherData responseData = objectMapper.readValue(feignService.weatherData(cityName,metric,ApiKey),WeatherData.class);

            return responseData;
        } catch (
                JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    public String getOutfitRecommendation(WeatherData weatherData) {

        double temperature = weatherData.getMain().getTemp();

        if (temperature >= 20 ) {
            return "Hava çok sıcak, yazlık kıyafetler tercih edebilirsiniz.";
        } else if (temperature >= 10) {
            return "Hava ılıman, ince bir kat daha ekleyebilirsiniz.";
        } else {
            return "Hava serin, kalın bir kat daha giyinmeyi düşünebilirsiniz.";
        }
    }
}





