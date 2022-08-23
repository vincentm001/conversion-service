package com.ayo.conversion.model.distance;

import com.ayo.conversion.constants.AppConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class LengthMeasurement {
    public double convert(double valueToConvert, double scale){
        return roundUp(valueToConvert * scale);
    }

    public double roundUp(double value){
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        bigDecimal = bigDecimal.setScale(AppConstants.ROUND_DECIMAL, RoundingMode.FLOOR);
        return bigDecimal.doubleValue();
    }
}
