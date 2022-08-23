package com.ayo.conversion.service.impl;

import com.ayo.conversion.configuration.LengthFactory;
import com.ayo.conversion.configuration.MeasurementConfig;
import com.ayo.conversion.configuration.TemperatureFactory;
import com.ayo.conversion.model.distance.Length;
import com.ayo.conversion.model.distance.LengthMeasurement;
import com.ayo.conversion.model.distance.LengthRequest;
import com.ayo.conversion.model.distance.LengthResponse;
import com.ayo.conversion.model.temperature.Temperature;
import com.ayo.conversion.model.temperature.TemperatureMeasurement;
import com.ayo.conversion.model.temperature.TemperatureRequest;
import com.ayo.conversion.model.temperature.TemperatureResponse;
import com.ayo.conversion.service.ConversionService;
import com.ayo.conversion.util.ConversionMapper;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

    private final LengthFactory lengthFactory;
    private final TemperatureFactory temperatureFactory;
    private final MeasurementConfig measurementConfig;
    private final ConversionMapper conversionMapper;

    public ConversionServiceImpl(LengthFactory lengthFactory, TemperatureFactory temperatureFactory, MeasurementConfig measurementConfig, ConversionMapper conversionMapper) {
        this.lengthFactory = lengthFactory;
        this.temperatureFactory = temperatureFactory;
        this.measurementConfig = measurementConfig;
        this.conversionMapper = conversionMapper;
    }

    @Override
    public LengthResponse convertLength(LengthRequest lengthRequest) {
        LengthMeasurement lengthMeasurement = lengthFactory.getLengthMeasurement(lengthRequest.getFrom());
        double results = lengthMeasurement.convert(lengthRequest.getConversionValue(), getUnitFromMap(lengthRequest));
        LengthResponse lengthResponse = conversionMapper.mapLengthResponse(lengthRequest, results);
        return lengthResponse;
    }

    private double getUnitFromMap(LengthRequest lengthRequest){
        double unit = Double.parseDouble(measurementConfig.getMeasurement()
                .get((lengthRequest.getFrom().name()+"_"+ lengthRequest.getTo().name()).toLowerCase()));
        return unit;
    }
    @Override
    public TemperatureResponse convertTemperature(TemperatureRequest temperature) {
        TemperatureMeasurement temperatureMeasurement = temperatureFactory.getTemperatureMeasurement(temperature.getFrom());
        double results = temperatureMeasurement.convert(temperature.getConversionValue(), temperature.getTo());
        TemperatureResponse temperatureResponse = conversionMapper.mapTemperatureResponse(temperature, results);
        return temperatureResponse;
    }
}
