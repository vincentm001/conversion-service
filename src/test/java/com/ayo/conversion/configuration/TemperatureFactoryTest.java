package com.ayo.conversion.configuration;

import com.ayo.conversion.model.temperature.Celsius;
import com.ayo.conversion.model.temperature.Fahrenheit;
import com.ayo.conversion.model.temperature.TemperatureMeasurement;
import com.ayo.conversion.model.temperature.TemperatureScale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureFactoryTest {

    TemperatureFactory temperatureFactory;

    @BeforeEach
    void init(){
        temperatureFactory = new TemperatureFactory();
    }

    @Test
    void should_return_celsius_instance() {
        TemperatureMeasurement temperatureMeasurement = temperatureFactory.getTemperatureMeasurement(TemperatureScale.CELSIUS);
        assertNotNull(temperatureMeasurement);
    }

    @Test
    void should_match_celsius_instance() {
        TemperatureMeasurement temperatureMeasurement = temperatureFactory.getTemperatureMeasurement(TemperatureScale.CELSIUS);
        assertEquals(temperatureMeasurement.getClass(), Celsius.class);
    }

    @Test
    void should_return_fahrenheit_instance() {
        TemperatureMeasurement temperatureMeasurement = temperatureFactory.getTemperatureMeasurement(TemperatureScale.FAHRENHEIT);
        assertNotNull(temperatureMeasurement);
    }

    @Test
    void should_match_fahrenheit_instance() {
        TemperatureMeasurement temperatureMeasurement = temperatureFactory.getTemperatureMeasurement(TemperatureScale.FAHRENHEIT);
        assertEquals(temperatureMeasurement.getClass(), Fahrenheit.class);
    }
}