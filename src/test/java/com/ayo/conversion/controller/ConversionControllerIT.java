package com.ayo.conversion.controller;

import com.ayo.conversion.model.distance.LengthRequest;
import com.ayo.conversion.model.distance.LengthScale;
import com.ayo.conversion.model.temperature.TemperatureRequest;
import com.ayo.conversion.model.temperature.TemperatureScale;
import com.ayo.conversion.service.ConversionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ConversionControllerIT {

    public static final double MILE_CONVERTED_FROM_KILOMETER = 12.42;
    public static final double KILOMETER_CONVERTED_FROM_MILE = 32.18;
    public static final double TEMPERATURE_TO_CONVERT = 25;
    public static final double FAHRENHEIT_CONVERTED_FROM_CELSIUS = 77;

    public static final double FAHRENHEIT_TO_CONVERT = 110;
    public static final double CELSIUS_CONVERTED_FROM_FAHRENHEIT = 43.33;
    public static final int LENGTH_TO_CONVERT = 20;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ConversionService conversionService;

    @Test
    void should_call_convert_length_kilometer_mile() throws Exception {
        LengthRequest lengthRequest = LengthRequest.builder()
                .conversionValue(LENGTH_TO_CONVERT)
                .from(LengthScale.KILOMETER)
                .to(LengthScale.MILE)
                .build();

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/conversion/length")
                        .content(objectMapper.writeValueAsString(lengthRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.convertedValue").exists())
                .andExpect(jsonPath("$.convertedValue",is(MILE_CONVERTED_FROM_KILOMETER)));

    }

    @Test
    void should_call_convert_length_mile_kilometer() throws Exception {
        LengthRequest lengthRequest = LengthRequest.builder()
                .conversionValue(LENGTH_TO_CONVERT)
                .from(LengthScale.MILE)
                .to(LengthScale.KILOMETER)
                .build();

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/conversion/length")
                                .content(objectMapper.writeValueAsString(lengthRequest))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.convertedValue").exists())
                .andExpect(jsonPath("$.convertedValue",is(KILOMETER_CONVERTED_FROM_MILE)));

    }

    @Test
    void should_call_convert_temperature_celsius_fahrenheit() throws Exception {
        TemperatureRequest temperatureRequest = TemperatureRequest.builder()
                .conversionValue(TEMPERATURE_TO_CONVERT)
                .from(TemperatureScale.CELSIUS)
                .to(TemperatureScale.FAHRENHEIT)
                .build();

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/conversion/temperature")
                                .content(objectMapper.writeValueAsString(temperatureRequest))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.convertedValue").exists())
                .andExpect(jsonPath("$.convertedValue",is(FAHRENHEIT_CONVERTED_FROM_CELSIUS)));

    }

    @Test
    void should_call_convert_temperature_fahrenheit_celsius() throws Exception {
        TemperatureRequest temperatureRequest = TemperatureRequest.builder()
                .conversionValue(FAHRENHEIT_TO_CONVERT)
                .from(TemperatureScale.FAHRENHEIT)
                .to(TemperatureScale.CELSIUS)
                .build();

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/conversion/temperature")
                                .content(objectMapper.writeValueAsString(temperatureRequest))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.convertedValue").exists())
                .andExpect(jsonPath("$.convertedValue",is(CELSIUS_CONVERTED_FROM_FAHRENHEIT)));

    }

}
