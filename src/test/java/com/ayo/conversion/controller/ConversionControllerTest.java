package com.ayo.conversion.controller;

import com.ayo.conversion.model.distance.LengthRequest;
import com.ayo.conversion.model.distance.LengthResponse;
import com.ayo.conversion.model.distance.LengthScale;
import com.ayo.conversion.model.temperature.TemperatureRequest;
import com.ayo.conversion.model.temperature.TemperatureResponse;
import com.ayo.conversion.model.temperature.TemperatureScale;
import com.ayo.conversion.service.ConversionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConversionControllerTest {

    public static final int CONVERTED_VALUE = 20;
    public static final int CONVERSION_VALUE = 20;
    public static final int ACTUAL_CONVERSION_VALUE = 20;
    public static final int CONVERTED_VALUE_TEMPERATURE = 20;
    public static final int CONVERSION_VALUE_TEMPERATURE = 20;
    public static final int ACTUAL_TEMPERATURE = 20;
    @InjectMocks
    ConversionController conversionController;

    @Mock
    ConversionService conversionService;

    @Test
    void should_call_convert_length() {

        Mockito.when(conversionService.convertLength(Mockito.any(LengthRequest.class)))
                .thenReturn(LengthResponse.builder()
                        .convertedValue(CONVERTED_VALUE)
                        .from(LengthScale.KILOMETER)
                        .to(LengthScale.MILE)
                        .build());

        LengthResponse lengthResponse = conversionController.convertLength(LengthRequest.builder()
                        .conversionValue(CONVERSION_VALUE)
                        .from(LengthScale.KILOMETER)
                        .to(LengthScale.MILE)
                .build());

        assertNotNull(lengthResponse);
        assertEquals(lengthResponse.getConvertedValue(), ACTUAL_CONVERSION_VALUE);
    }

    @Test
    void should_call_convert_temperature() {
        Mockito.when(conversionService.convertTemperature(Mockito.any(TemperatureRequest.class)))
                .thenReturn(TemperatureResponse.builder()
                        .convertedValue(CONVERTED_VALUE_TEMPERATURE)
                        .from(TemperatureScale.CELSIUS)
                        .to(TemperatureScale.FAHRENHEIT)
                        .build());

        TemperatureResponse temperatureResponse = conversionController.convertTemperature(TemperatureRequest.builder()
                .conversionValue(CONVERSION_VALUE_TEMPERATURE)
                .from(TemperatureScale.CELSIUS)
                .to(TemperatureScale.FAHRENHEIT)
                .build());

        assertNotNull(temperatureResponse);
        assertEquals(temperatureResponse.getConvertedValue(), ACTUAL_TEMPERATURE);
    }
}