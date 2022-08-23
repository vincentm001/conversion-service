package com.ayo.conversion.service;

import com.ayo.conversion.model.distance.Length;
import com.ayo.conversion.model.distance.LengthRequest;
import com.ayo.conversion.model.distance.LengthResponse;
import com.ayo.conversion.model.temperature.Temperature;
import com.ayo.conversion.model.temperature.TemperatureRequest;
import com.ayo.conversion.model.temperature.TemperatureResponse;

public interface ConversionService {
    LengthResponse convertLength(LengthRequest lengthRequest);

    //double convertToImperial(LengthRequest lengthRequest);
    TemperatureResponse convertTemperature(TemperatureRequest temperatureRequest);
}
