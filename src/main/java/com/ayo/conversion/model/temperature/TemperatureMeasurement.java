package com.ayo.conversion.model.temperature;

import com.ayo.conversion.model.temperature.TemperatureScale;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class TemperatureMeasurement {

    public abstract double convert(double valueToConvert, TemperatureScale temperatureScale);

    public double roundUp(double value){
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.FLOOR);
        return bigDecimal.doubleValue();
    }
}
