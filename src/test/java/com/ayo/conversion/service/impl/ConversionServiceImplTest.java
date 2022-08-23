package com.ayo.conversion.service.impl;

import com.ayo.conversion.configuration.LengthFactory;
import com.ayo.conversion.configuration.MeasurementConfig;
import com.ayo.conversion.configuration.TemperatureFactory;
import com.ayo.conversion.model.distance.Kilometer;
import com.ayo.conversion.model.distance.LengthRequest;
import com.ayo.conversion.model.distance.LengthResponse;
import com.ayo.conversion.model.distance.LengthScale;
import com.ayo.conversion.model.temperature.Celsius;
import com.ayo.conversion.model.temperature.TemperatureRequest;
import com.ayo.conversion.model.temperature.TemperatureResponse;
import com.ayo.conversion.model.temperature.TemperatureScale;
import com.ayo.conversion.util.ConversionMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.yml")
class ConversionServiceImplTest {

    @Mock
    ConversionMapper conversionMapper;
    @Mock
    LengthFactory lengthFactory;
    @Mock
    TemperatureFactory temperatureFactory;
    @Mock
    MeasurementConfig measurementConfig;

    @InjectMocks
    ConversionServiceImpl conversionService;

    @BeforeEach
    void init(){
    }

    @Disabled
    @Test
    void should_call_convert_length() {

        when(lengthFactory.getLengthMeasurement(any(LengthScale.class))).thenReturn(any(Kilometer.class));

        Map<String, String> configs = new HashMap<>();
        configs.put("kilometer_mile","0.621371");
        when(measurementConfig.getMeasurement()).thenReturn(configs);

        LengthResponse lengthResponse = conversionService.convertLength(LengthRequest.builder()
                        .conversionValue(20)
                        .from(LengthScale.KILOMETER)
                        .to(LengthScale.MILE)
                .build());

        assertNotNull(lengthResponse);

    }

    @Disabled
    @Test
    void should_call_convert_temperature() {

        when(temperatureFactory.getTemperatureMeasurement(any(TemperatureScale.class))).thenReturn(any(Celsius.class));

        TemperatureResponse temperatureResponse = conversionService.convertTemperature(TemperatureRequest.builder()
                .conversionValue(20)
                .from(TemperatureScale.CELSIUS)
                .to(TemperatureScale.FAHRENHEIT)
                .build());

        assertNotNull(temperatureResponse);
    }
}