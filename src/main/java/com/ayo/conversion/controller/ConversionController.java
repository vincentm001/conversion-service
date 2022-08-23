package com.ayo.conversion.controller;

import com.ayo.conversion.model.distance.LengthRequest;
import com.ayo.conversion.model.distance.LengthResponse;
import com.ayo.conversion.model.temperature.TemperatureRequest;
import com.ayo.conversion.model.temperature.TemperatureResponse;
import com.ayo.conversion.service.ConversionService;
import com.ayo.conversion.util.ConversionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/conversion")
public class ConversionController {

    private final ConversionService conversionService;
    private final ConversionMapper conversionMapper;

    public ConversionController(ConversionService conversionService, ConversionMapper conversionMapper) {
        this.conversionService = conversionService;
        this.conversionMapper = conversionMapper;
    }

    @PostMapping("/length")
    public LengthResponse convertLength(@RequestBody LengthRequest lengthRequest){
        log.info("Received Length Request : " + lengthRequest);
        LengthResponse lengthResponse = conversionService.convertLength(lengthRequest);
        log.info("Done Processing Request");
        return lengthResponse;
    }

    @PostMapping("/temperature")
    public TemperatureResponse convertTemperature(@RequestBody TemperatureRequest temperatureRequest){
        log.info("Received Temperature Request : " + temperatureRequest);
        TemperatureResponse temperatureResponse = conversionService.convertTemperature(temperatureRequest);
        log.info("Done Processing Request");
        return temperatureResponse;
    }
}
