package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAvgTemp() {
        double sumTemp = 0.0;
        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            sumTemp += temperature.getValue();
        }
        double result = sumTemp / this.temperatures.getTemperatures().size();
        return result;
    }

    public double calculateMedianTemp() {
        double temperaturesArray[] = new double[this.temperatures.getTemperatures().size()];
        int i = 0;
        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            temperaturesArray[i] = temperature.getValue();
            i++;
        }
        Arrays.sort(temperaturesArray);
        double result;
        if(temperaturesArray.length % 2 == 0){
            result = (temperaturesArray[temperaturesArray.length / 2 - 1] + temperaturesArray[temperaturesArray.length / 2]) / 2;
        } else {
            result = temperaturesArray[(temperaturesArray.length - 1) / 2];
        }
        return result;
    }
}
