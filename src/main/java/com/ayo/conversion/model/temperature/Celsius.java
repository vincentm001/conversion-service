package com.ayo.conversion.model.temperature;

import com.ayo.conversion.exception.ConversionNotSupportedException;

import static com.ayo.conversion.constants.AppConstants.*;

public class Celsius extends TemperatureMeasurement {
    private Celsius(){}

    public static Celsius createCelsius(){
        return new Celsius();
    }

    @Override
    public double convert(double valueToConvert, TemperatureScale temperatureScale) {
        double results = 0.0;
        switch (temperatureScale){
            case CELSIUS:
                throw new ConversionNotSupportedException("Not allowed to convert to the same measurement");
            case FAHRENHEIT:
                results = ( valueToConvert * CELSIUS_SCALAR) + DEGREE;
                break;
            default:
                throw new ConversionNotSupportedException("Measurement not supported");
        }
        return roundUp(results);
    }
}
