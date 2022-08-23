package com.ayo.conversion.util;

import com.ayo.conversion.model.distance.*;
import com.ayo.conversion.model.temperature.*;
import org.springframework.stereotype.Component;

@Component
public class ConversionMapper {

    public Temperature mapTemperature(TemperatureRequest temperatureRequest) {
        return Temperature.builder()
                .conversionValue(temperatureRequest.getConversionValue())
                .from(temperatureRequest.getFrom())
                .to(temperatureRequest.getTo())
                .build();
    }

    public TemperatureResponse mapTemperatureResponse(TemperatureRequest temperatureRequest, double results) {
        return TemperatureResponse.builder()
                .convertedValue(results)
                .from(temperatureRequest.getFrom())
                .to(temperatureRequest.getTo())
                .build();
    }

    public Length mapLength(LengthRequest lengthRequest) {
        return Length.builder()
                .conversionValue(lengthRequest.getConversionValue())
                .from(lengthRequest.getFrom())
                .to(lengthRequest.getTo())
                .build();
    }

    public LengthResponse mapLengthResponse(LengthRequest lengthRequest, double results) {
        return LengthResponse.builder()
                .convertedValue(results)
                .from(lengthRequest.getFrom())
                .to(lengthRequest.getTo())
                .build();
    }
}
