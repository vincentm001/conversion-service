package com.ayo.conversion.configuration;

import com.ayo.conversion.exception.ConversionNotSupportedException;
import com.ayo.conversion.model.distance.*;
import org.springframework.stereotype.Component;

@Component
public class LengthFactory {

    public LengthMeasurement getLengthMeasurement(LengthScale from) {

        LengthMeasurement lengthMeasurement;
        switch (from){
            case KILOMETER:
                lengthMeasurement = Kilometer.createKilometer();
                break;
            case METER:
                lengthMeasurement = Meter.createMeter();
                break;
            case MILE:
                lengthMeasurement = Mile.createMile();
                break;
            case INCH:
                lengthMeasurement = Inch.createInch();
                break;
            default:
                throw new ConversionNotSupportedException("Measurement not supported");
        }
        return lengthMeasurement;
    }
}
