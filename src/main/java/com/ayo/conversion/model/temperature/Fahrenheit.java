package com.ayo.conversion.model.temperature;

import com.ayo.conversion.exception.ConversionNotSupportedException;

import static com.ayo.conversion.constants.AppConstants.*;

public class Fahrenheit extends TemperatureMeasurement {

    private Fahrenheit(){}

    public static Fahrenheit createFahrenheit(){
        return new Fahrenheit();
    }

    @Override
    public double convert(double conversionValue, TemperatureScale temperatureScale) {
        double results = 0.0;
        switch (temperatureScale){
            case FAHRENHEIT:
                throw new ConversionNotSupportedException("Not allowed to convert to the same measurement");
            case CELSIUS:
                results = (FAHRENHEIT_SCALAR) * (conversionValue - DEGREE);
                break;
            default:
                throw new ConversionNotSupportedException("Measurement not supported");
        }
        return roundUp(results);
    }
}
