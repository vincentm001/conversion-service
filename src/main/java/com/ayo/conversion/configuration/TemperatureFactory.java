package com.ayo.conversion.configuration;

import com.ayo.conversion.exception.ConversionNotSupportedException;
import com.ayo.conversion.model.temperature.Celsius;
import com.ayo.conversion.model.temperature.Fahrenheit;
import com.ayo.conversion.model.temperature.TemperatureMeasurement;
import com.ayo.conversion.model.temperature.TemperatureScale;
import org.springframework.stereotype.Component;

@Component
public class TemperatureFactory {

    public TemperatureMeasurement getTemperatureMeasurement(TemperatureScale measurement) {
        TemperatureMeasurement temperatureMeasurement;
        switch (measurement){
            case CELSIUS:
                temperatureMeasurement = Celsius.createCelsius();
                break;
            case FAHRENHEIT:
                temperatureMeasurement = Fahrenheit.createFahrenheit();
                break;
            default:
                throw new ConversionNotSupportedException("Measurement not supported");
        }
        return temperatureMeasurement;
    }
}
