package com.ayo.conversion.configuration;

import com.ayo.conversion.model.distance.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthFactoryTest {

    LengthFactory lengthFactory;

    @BeforeEach
    void init(){
        lengthFactory = new LengthFactory();
    }

    @Test
    void should_return_kilometer_instance() {
        LengthMeasurement lengthMeasurement = lengthFactory.getLengthMeasurement(LengthScale.KILOMETER);
        assertNotNull(lengthMeasurement);
    }

    @Test
    void should_match_kilometer_instance() {
        LengthMeasurement lengthMeasurement = lengthFactory.getLengthMeasurement(LengthScale.KILOMETER);
        assertEquals(lengthMeasurement.getClass(), Kilometer.class);
    }

    @Test
    void should_return_meter_instance() {
        LengthMeasurement lengthMeasurement = lengthFactory.getLengthMeasurement(LengthScale.METER);
        assertNotNull(lengthMeasurement);
    }

    @Test
    void should_match_meter_instance() {
        LengthMeasurement lengthMeasurement = lengthFactory.getLengthMeasurement(LengthScale.METER);
        assertEquals(lengthMeasurement.getClass(), Meter.class);
    }

    @Test
    void should_return_mile_instance() {
        LengthMeasurement lengthMeasurement = lengthFactory.getLengthMeasurement(LengthScale.MILE);
        assertNotNull(lengthMeasurement);
    }

    @Test
    void should_match_mile_instance() {
        LengthMeasurement lengthMeasurement = lengthFactory.getLengthMeasurement(LengthScale.MILE);
        assertEquals(lengthMeasurement.getClass(), Mile.class);
    }

    @Test
    void should_return_inch_instance() {
        LengthMeasurement lengthMeasurement = lengthFactory.getLengthMeasurement(LengthScale.INCH);
        assertNotNull(lengthMeasurement);
    }

    @Test
    void should_match_inch_instance() {
        LengthMeasurement lengthMeasurement = lengthFactory.getLengthMeasurement(LengthScale.INCH);
        assertEquals(lengthMeasurement.getClass(), Inch.class);
    }
}